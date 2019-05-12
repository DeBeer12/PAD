import RPi.GPIO as GPIO
import time
import mysql.connector
from mysql.connector import errorcode
from datetime import date, datetime, timedelta
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
global gamestand

#GPIO pins declareren
sensorGat1 = 14
sensorGat2 = 15
sensorGat3 = 18
sensorGat4 = 23
sensorGat5 = 24
knop = 25

#GPIO inputs opzetten
GPIO.setup(sensorGat1, GPIO.IN)
GPIO.setup(sensorGat2, GPIO.IN)
GPIO.setup(sensorGat3, GPIO.IN)
GPIO.setup(sensorGat4, GPIO.IN)
GPIO.setup(sensorGat5, GPIO.IN)
GPIO.setup(knop, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)

gamestand =0

#Aantal hits in gaten aan het begin van spel
hitsGat1=0
hitsGat2=0
hitsGat3=0
hitsGat4=0
hitsGat5=0


#instrucie om spel te starten
#bij het indrukken van de knop worden de aantal ballen naar 10 gezet
def wait_for_start():
        global aantalBallen
        global gamestand
        aantalBallen =0
        gamestand =0
        
        while aantalBallen ==0 and gamestand ==0:
                knopStaat = GPIO.input(knop)
                if knopStaat == 1 and gamestand ==0:
                        clear_gamelive()
                        
                        aantalBallen = 10
                        gamestand =1
                        print("Game gestart!")
                        insert_game()
                        
def clear_gamelive():
        
        clear_table= "DELETE FROM Gametest WHERE GAMEID <> 1"
        #Connectie met database
        try:
                mydb = mysql.connector.connect(user='oosterr4', password='XOxZwUxliy/8+0', host='oege.ie.hva.nl', database='zoosterr4')
                cursor = mydb.cursor()
        
                clear_table = "DELETE FROM Gametest WHERE GAMEID <> 1"
                cursor.execute(clear_table)
                mydb.commit()
        
        finally:
                #Connectie met database afsluiten
                cursor.close()
                mydb.close()

                        
def insert_game():
        #global zodat de game id in andere deel van code gebruikt kan worden
        global current_GameID
        global formatted_date
        
        #Connectie met database
        try:
                mydb = mysql.connector.connect(user='oosterr4', password='XOxZwUxliy/8+0', host='oege.ie.hva.nl', database='zoosterr4')
                cursor = mydb.cursor()
        except:
                print("Geen verbinding met database")
        #insert query voor het aanmaken van een nieuwe game               
        insert_GameLive= "INSERT INTO Gametest (Gat1,Gat2,Gat3,Gat4,Gat5,Time) VALUES (%s, %s, %s, %s, %s, %s)"
        
        #datum en tijd voor game insert
        current_Date = datetime.now()
        formatted_date = current_Date.strftime('%Y-%m-%d %H:%M:%S')
        
        #inserten van een nieuwe game
        try:
                cursor.execute(insert_GameLive, (str(hitsGat1), str(hitsGat2), str(hitsGat3), str(hitsGat4), str(hitsGat5), str(formatted_date)))
                mydb.commit()
                
                #Feedback met datum
                print("Game aangemaakt in database")
                #Huidige game id opslaan en uitprinten
                current_GameID=cursor.lastrowid
                print("GameID:", current_GameID)
                print("Starttijd: ",formatted_date,"\n")
                game()
                
                
        except errorcode as error:
                print(error)
        
        finally:
                #Connectie met database afsluiten
                cursor.close()
                mydb.close()
                
                
def game():
        
        #Beginstaat sensoren
        staat_Sensor1=1
        staat_Sensor2=1
        staat_Sensor3=1
        staat_Sensor4=1
        staat_Sensor5=1

        #Vorige staat sensoren
        pstaat_Sensor1=0
        pstaat_Sensor2=0
        pstaat_Sensor3=0
        pstaat_Sensor4=0
        pstaat_Sensor5=0

        #Aantal hits in gaten aan het begin van spel
        hitsGat1=0
        hitsGat2=0
        hitsGat3=0
        hitsGat4=0
        hitsGat5=0
        global formatted_date
        global current_GameID
        global aantalBallen
        global gamestand
        #continu uitlezen van sensoren en bij een trigger deze wijzeging doorgeven aan de huidige game-row
        try:                               
                                
                #connectie met database maken
                try:
                        mydb = mysql.connector.connect(user='oosterr4', password='XOxZwUxliy/8+0', host='oege.ie.hva.nl', database='zoosterr4')
                        cursor = mydb.cursor()
                except:
                        print("Geen verbinding met database")
                        
                
                
                #standaard input van sensoren declaren       
                while GPIO.input(sensorGat1)==0:
                        staat_Sensor1=1
                while GPIO.input(sensorGat2)==0:
                        staat_Sensor2=1
                
                #instructie naar gebruiker dat het spel klaar is
                print ("Let's START the SkeeBall")
                
                #aantal ballen voor de gebruiker om te gooien
                print ("Aantal ballen:", aantalBallen)
                print("\n")
                     
                
                #als de knop is ingedrukt krijgt de gebruiker 10 ballen dan start het uitlezen
                if aantalBallen==10:
                        gamestand ==1
                        #de sensoren blijven uitlezen totdat de gebruiker 0 ballen heeft om te gooien
                        while aantalBallen >0:
                                
                                #huidige staat van sensor declareren
                                staat_Sensor1=GPIO.input(sensorGat1)
                                staat_Sensor2=GPIO.input(sensorGat2)
                                staat_Sensor3=GPIO.input(sensorGat3)
                                staat_Sensor4=GPIO.input(sensorGat4)
                                staat_Sensor5=GPIO.input(sensorGat5)
                                
                                #sensor 1
                                if staat_Sensor1==0 and pstaat_Sensor1 ==0: 
                                        #feedback van een hit in gat 1
                                        print ("Hit gat 1!")
                                        #verminder aantal ballen van gebruiker met 1
                                        aantalBallen = aantalBallen-1
                                        #verhoog aantal hits van gat 1 met 1
                                        hitsGat1 = hitsGat1+1
                                        #feedback aan gebruiker van hoeveel ballen hij nog heeft
                                        print ("Aantal ballen:", aantalBallen)
                                        #pauze voor het vermijden van een dubbele lezing
                                        time.sleep(1)
                                        #vorige staat naar 1
                                        pstaat_Sensor1=1
                                        
                                        #update db gat1
                                        update_GameRecord= "UPDATE Gametest SET Gat1 = %s where GAMEID = %s"
                                        input_update = (str(hitsGat1), str(current_GameID))
                                        print ("Score gat 1: ",hitsGat1)
                                        cursor.execute(update_GameRecord, input_update)
                                        mydb.commit()
                                        #feedback van succelvolle update
                                        #print("DB Update succesvol\n")
                                        print("\n")
                                        
                                #het resetten van de standen voor sensor 1
                                elif staat_Sensor1==1 and pstaat_Sensor1==1:
                                        #print("ready_1") 
                                        pstaat_Sensor1=0
                                time.sleep(0.01)
                                
                                #comments van sensor 1 geldt voor ook sensor 2
                                
                                #sensor 2
                                if staat_Sensor2==0 and pstaat_Sensor2 ==0: 
                                        print ("Hit gat 2!")
                                        aantalBallen = aantalBallen-1
                                        hitsGat2 = hitsGat2+1
                                        print ("Aantal ballen:", aantalBallen)  
                                        time.sleep(1)
                                        pstaat_Sensor2=1
                                        
                                        #update db gat2
                                        update_GameRecord= "UPDATE Gametest SET Gat2 = %s where GAMEID = %s"
                                        print ("Score gat 2: ",hitsGat2)
                                        input_update = (str(hitsGat2), str(current_GameID))
                                        cursor.execute(update_GameRecord, input_update)
                                        mydb.commit()
                                        #print("DB Update succesvol\n")
                                        print("\n")

                                        
                                elif staat_Sensor2==1 and pstaat_Sensor2==1:
                                        #print("ready_2") 
                                        pstaat_Sensor2=0
                                time.sleep(0.01)
                                
                                #sensor 3
                                if staat_Sensor3==0 and pstaat_Sensor3 ==0: 
                                        print ("Hit gat 3!")
                                        aantalBallen = aantalBallen-1
                                        hitsGat3 = hitsGat3+1
                                        print ("Aantal ballen:", aantalBallen)
                                        time.sleep(1)
                                        pstaat_Sensor3=1
                                        
                                        #update db gat3
                                        update_GameRecord= "UPDATE Gametest SET Gat3 = %s where GAMEID = %s"
                                        print ("Score gat 3: ",hitsGat3)
                                        input_update = (str(hitsGat3), str(current_GameID))
                                        cursor.execute(update_GameRecord, input_update)
                                        mydb.commit()
                                        #print("DB Update succesvol\n")
                                        print("\n")
                                        
                                elif staat_Sensor3==1 and pstaat_Sensor3==1:
                                        #print("ready_3") 
                                        pstaat_Sensor3=0
                                time.sleep(0.01)
                                
                                #sensor 4                        
                                if staat_Sensor4==0 and pstaat_Sensor4 ==0: 
                                        print ("Hit gat 4!")
                                        aantalBallen = aantalBallen-1
                                        hitsGat4 = hitsGat4+1
                                        print ("Aantal ballen:", aantalBallen)
                                        time.sleep(1)
                                        pstaat_Sensor4=1
                                        
                                        #update db gat4
                                        update_GameRecord= "UPDATE Gametest SET Gat4 = %s where GAMEID = %s"
                                        print ("Score gat 4: ",hitsGat4)
                                        input_update = (str(hitsGat4), str(current_GameID))
                                        cursor.execute(update_GameRecord, input_update)
                                        mydb.commit()
                                        #print("DB Update succesvol\n")
                                        print("\n")
                                        
                                elif staat_Sensor4==1 and pstaat_Sensor4==1:
                                        #print("ready_4") 
                                        pstaat_Sensor4=0
                                time.sleep(0.01)
                                
                                #sensor 5                        
                                if staat_Sensor5==0 and pstaat_Sensor5 ==0: 
                                        print ("Hit gat 5!")
                                        aantalBallen = aantalBallen-1
                                        hitsGat5 = hitsGat5+1
                                        print ("Aantal ballen:", aantalBallen)
                                        time.sleep(1)
                                        pstaat_Sensor5=1
                                        
                                        #update db gat5
                                        update_GameRecord= "UPDATE Gametest SET Gat5 = %s where GAMEID = %s"
                                        print ("Score gat 5: ",hitsGat5)
                                        input_update = (str(hitsGat5), str(current_GameID))
                                        cursor.execute(update_GameRecord, input_update)
                                        mydb.commit()
                                        #print("DB Update succesvol\n")
                                        print("\n")
                                        
                                elif staat_Sensor5==1 and pstaat_Sensor5==1:
                                        #print("ready_5") 
                                        pstaat_Sensor5=0
                                time.sleep(0.01)
                                        
                        if aantalBallen ==0 and gamestand ==1:
                                
                                #datum en tijd voor game insert
                                eind_Date = datetime.now()
                                eind_datumtijd = eind_Date.strftime('%Y-%m-%d %H:%M:%S')
                                
                                print("Game afgelopen")
                                print("Eindtijd: ", eind_datumtijd)
                                print("\n  --------------------------")
                                gamestand = 2
                                insert_GameRecords= "INSERT INTO GamesRecords (GameID,Gat1,Gat2,Gat3,Gat4,Gat5,Start_Time,End_Time) VALUES (%s, %s, %s, %s, %s, %s, %s, %s)"
                                cursor.execute(insert_GameRecords, (str(current_GameID), str(hitsGat1), str(hitsGat2), str(hitsGat3), str(hitsGat4), str(hitsGat5), str(formatted_date), str(eind_datumtijd)))
                                mydb.commit()
                               
                                        
        except KeyboardInterrupt:
                print ("Quit")
                GPIO.cleanup()

                                
while True:
        try:
                if gamestand ==0:
                        print("Om een spel te starten: \nDruk op de knop\n")
                        wait_for_start()
                if gamestand ==2:
                        
                        print("Om een nieuw spel te starten: \nDruk op de knop\n")
                        wait_for_start()
        except KeyboardInterrupt:
                print ("Quit")
                GPIO.cleanup()
