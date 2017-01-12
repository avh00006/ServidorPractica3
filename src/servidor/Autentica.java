package servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;
import static servidor.Autentica.MSG_ERRORAUT;
import static servidor.Autentica.MSG_QUIT;
import static servidor.Autentica.MSG_WELCOME;
import static servidor.Protocolo.CRLF;
import static servidor.Protocolo.ECHO;
import static servidor.Protocolo.ERROR;
import static servidor.Protocolo.OK;
import static servidor.Protocolo.QUIT;
import static servidor.Protocolo.SP;
import session.Session;

public class Autentica implements Runnable, Protocolo {

    Socket mSocket;
    public static final String MSG_WELCOME = "Bienvenido al servidor de pruebas";
    public static final String MSG_QUIT = "Adios, hasta la vista!";
    public static final String MSG_ERRORAUT = "Usuario o clave incorrectos";

    public Autentica(Socket s) {
        mSocket = s;
    }

    @Override
    public void run() {
        String inputData = null;
        String outputData = "";
        String comando = "";
        String parametro = "";
        String tempUser = "";
        LinkedList<Hombro> listaHombro=new LinkedList<Hombro>();
        LinkedList<Piernas> listaPiernas=new LinkedList<Piernas>();
        LinkedList<Espalda> listaEspalda=new LinkedList<Espalda>();
        String Lun = "Lunes";
        String Mar = "Martes";
        String Mie = "Miercoles";
        boolean salir = false;
        int estado = S_USER;

        if (mSocket != null) {
            try {

                // Conexi�n con la entrada y salida del socket
                DataOutputStream outputStream = new DataOutputStream(mSocket.getOutputStream());
                BufferedReader inputStream = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

                // Se env�a el mensaje de bienvenida
                outputData = OK + SP + MSG_WELCOME + CRLF;
                outputStream.write(outputData.getBytes());
                outputStream.flush();

                while ((inputData = inputStream.readLine()) != null && !salir) {
                    System.out.println("SERVIDOR [Recibido]> " + inputData);
                    String fields[] = inputData.split(" ");

					// Se compreba si el mensaje es un comando solo o comando
                    // con par�metro
                    if (fields.length == 1) {// No hay espacios, debe ser solo
                        // un comando
                        comando = inputData;
                        parametro = null;
                    } else if (fields.length >= 2) {// Hay al menos un espacio
                        // ya qe el m�todo split ha
                        // devuelto dos o m�s
                        // cadenas
                        comando = fields[0];// El comando debe ser el primer
                        // campo
                        // Se extrae el par�metro que se considera que es todo
                        // aquello a partir del primer espacio
                        parametro = inputData.substring(inputData.indexOf(" "));
                        parametro = parametro.trim();// Se limpian los espacios
                        // adicionales
                    }
                    switch (estado) {
                        case S_USER:// Estado USER
                            if (comando.equalsIgnoreCase(QUIT)) {// En todos los
                                // estados, si
                                // de salida
                                outputData = OK + SP + MSG_QUIT + CRLF;
                                salir = true;
                            } else if (comando.equalsIgnoreCase(USER) && parametro != null) {
                                tempUser = parametro;
                                outputData = OK + CRLF;
                                estado++;// Se incrementa el estado aunque a�n no se
                                // compara
                            } else {// No es un comando v�lido
                                outputData = ERROR + CRLF;
                            }
                            break;
                        case S_PASS:// Estado PASS
                            if (comando.equalsIgnoreCase(QUIT)) {
                                outputData = OK + SP + MSG_QUIT + CRLF;
                                salir = true;
                            } else if (comando.equals(PASS) && parametro != null) {
                                if (tempUser.compareTo(USERNAME) == 0 && parametro.compareTo(PASSWORD) == 0) {
                                    outputData = Session.getNewSession(tempUser,parametro);
                                    estado++;// Como el usuario y clave coinciden se
                                    // incrementa estado
                                    System.out.println("SERVIDOR> Sesión iniciada. Datos: " + outputData);
                                } else {//Autenticaci�n err�nea
                                    outputData = ERROR + SP + MSG_ERRORAUT + CRLF;
                                    estado = S_USER;
                                }
                            } else {// No es un comando v�lido
                                outputData = ERROR + CRLF;
                            }
                            break;
                        case S_OPER:// Estado OPERACION

                                                String res=""; 
						if (comando.equalsIgnoreCase(QUIT)) {
							outputData = OK + SP + MSG_QUIT + CRLF;
							salir = true;
						} else if (comando.equalsIgnoreCase(ECHO)) {
							if (parametro != null){
								outputData = OK + SP + parametro + CRLF;// se
                                                                
                                                                if (Lun.equals(parametro)){
                                                                   
                                                                   listaHombro=Consultas.getHombro();
                                                                   listaPiernas=Consultas.getPiernas();
                                                                   
                                                                   res="{";
                                                                   res+="ejercicio1:[";
                                                                    for(int i=0;i<listaHombro.size();i++){
                                                                    res+="{grupo:hombro,id:"+listaHombro.get(0).getId()+",serie:"+listaHombro.get(0).getSerie()+",repeticion:"+listaHombro.get(0).getRepeticion()+",nombre:"+listaHombro.get(0).getNombre()+"}";
                                                                    }
                                                                    res+="],ejercicio2:[";
                                                                    for(int i=0;i<listaPiernas.size();i++){
                                                                    res+="{grupo:piernas,id:"+listaPiernas.get(0).getId()+",serie:"+listaPiernas.get(0).getSerie()+",repeticion:"+listaPiernas.get(0).getRepeticion()+",nombre:"+listaPiernas.get(0).getNombre()+"}";
                                                                    }
                                                                    res+="]}";
                                                                    
                                                                    parametro = res;
                                                                    outputData = parametro + CRLF;
                                                                    
                                                                }
                                                                
								if (Mar.equals(parametro)){
                                                                    
                                                                    
                                                                    listaEspalda=Consultas.getEspalda();
                                                                    listaPiernas=Consultas.getPiernas();
                                                                    
                                                                    res="{";
                                                                   res+="ejercicio1:[";
                                                                    for(int i=0;i<listaEspalda.size();i++){
                                                                    res+="{grupo:espalda,id:"+listaEspalda.get(0).getId()+",serie:"+listaEspalda.get(0).getSerie()+",repeticion:"+listaEspalda.get(0).getRepeticion()+",nombre:"+listaEspalda.get(0).getNombre()+"}";
                                                                    }
                                                                    res+="],ejercicio2:[";
                                                                    for(int i=0;i<listaPiernas.size();i++){
                                                                    res+="{grupo:piernas,id:"+listaPiernas.get(0).getId()+",serie:"+listaPiernas.get(0).getSerie()+",repeticion:"+listaPiernas.get(0).getRepeticion()+",nombre:"+listaPiernas.get(0).getNombre()+"}";
                                                                    }
                                                                    res+="]}";
                                     
                                                                    
                                                                    parametro = res;
                                                                    outputData = parametro + CRLF;
                                                           									// misma
                                                                }										// cadena
                                                        }											// recibida
							else// El cliente no envi� par�metro alguno
								outputData = ERROR + CRLF;
						} else// No es un comando v�lido
							outputData = ERROR + CRLF;
						break;
                    }
                    outputStream.write(outputData.getBytes());
                    outputStream.flush();
                }
                System.out.println("SERVIDOR> Conexi�n finalizada");
                outputStream.close();
                inputStream.close();
                mSocket.close();
            } catch (SocketException se) {
                System.err.println("SERVIDOR [Finalizado]> " + se.getMessage());
            } catch (IOException ioe) {
                System.err.println("SERVIDOR [Finalizado]> " + ioe.getMessage());
            }

        }

    }

}