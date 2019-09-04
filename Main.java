/*crear un programa que solicite al usuario, usuario y contraseña, validar que los datos sean correctos
si los datos son correctos que muestre el siguiente menu 

1-Calculadora
2-Ahorcado
3-Acerca de
4-Cerrar Sesion
5-Salir

*/

import java.util.*;
import java.util.HashSet;
import java.util.Set;

class Main{

  public static void main(String args[]){

    int intentos=0;
    int opcion;
    int incorrectos=3;

    while(intentos<3){

      Scanner leer=new Scanner(System.in);

      System.out.print("\nIngrese su usuario: ");
      String usuario=leer.nextLine();

      System.out.print("Ingrese su contrasena: ");
      String clave=leer.nextLine();

      if(!usuario.equals("prog3") || !clave.equals("prog3")){
        incorrectos--;
        System.out.println("Usuario/Clave incorrectas le quedan "+incorrectos+" intentos");
        if(incorrectos==0){
          System.out.println("Su cuenta esta bloquada");
          break;
        }
      }

      

      while(usuario.equals("prog3") && clave.equals("prog3")){                            System.out.println("\nBienvenido al sistema");
        int menu=1;
        while(menu==1){
          System.out.println("Elija una opcion: ");
          System.out.println("\n1.Calculadora \n2.Ahorcado \n3.Acerca de \n4.Cerrar sesion \n5.Salir");
          System.out.print("Eleccion:");
          opcion=leer.nextInt();	

          switch(opcion){	
            case 1:  
                int operacion;
                System.out.println("\nCalculadora\nQue operacion quiere ejecutar");
                System.out.println("1.Suma\n2.Resta\n3.Multiplicacion\n4.Division");
                operacion=leer.nextInt();
                System.out.print("Ingrese el primer numero: ");
                int numero1=leer.nextInt();
                System.out.print("Ingrese el segundo numero: ");
                int numero2=leer.nextInt();

                switch(operacion){
                  case 1:                   

                    int suma=numero1+numero2;

                    System.out.println("la suma de los numeros es: "+suma);
                    break;
                  case 2:                   

                    int resta=numero1-numero2;

                    System.out.println("la resta de los numeros es: "+resta);
                    break;
                  case 3:                    

                    int multiplicacion=numero1*numero2;

                    System.out.println("la multiplicacion de los numeros es: "+multiplicacion);
                    break;
                  case 4:                                        

                    int division=numero1/numero2;

                    System.out.println("la division de los numeros es: "+division);
                    break;
                  default:
                    System.out.println("Opcion no valida");
                  break;
                }           
                System.out.println("\nPara retornar al menu ingresa 1");	
                menu=leer.nextInt();
            break;
            case 2: 
              int intentos2 = 0;

              Set<String> intentosAnteriores = new HashSet<>();
              Scanner leer2 = new Scanner(System.in);
              System.out.print("\nIngresa la palabra a adivinar: ");
              String palabraAdivinar = leer2.nextLine().toUpperCase();
              int longitud = palabraAdivinar.length();

              char[] palabraAdivinarChar = palabraAdivinar.toCharArray(); //crear un array de caracteres 

              //crea e imprime un arreglo de caracteres de la misma longitud de la palabra a adivinar 
              char[] nuevoarray = palabraAdivinar.toCharArray();
              System.out.println("La palabra secreta es: ");

              for (int i = 0; i < longitud; i++) {
                  nuevoarray[i] = '*';
              }

              
              while (!String.valueOf(nuevoarray).equals(palabraAdivinar)) {

                  //inicializamos las variables del bucle
                  boolean correcto = false;             
                  boolean repetido = false; 

                  //imprime la palabra censurada
                  for (int a = 0; a < longitud; a++) {
                      System.out.print(nuevoarray[a]);
                  }
                  System.out.println();

                  // pregunta al usuario a adivinar, luego almacena la letra
                  System.out.println("Ingresa una letra: ");
                  String intento = leer2.next().toUpperCase().substring(0, 1);
                  char intentoChar = intento.charAt(0); //gets char data from scanner

                  //verifica si el usuario ya ingreso una letra repetida 
                  if (intentosAnteriores.contains(intento)) {
                      System.out.println("La letra ingresada ya fue seleccionada. Los intentos anteriores son: ");
                      System.out.println(intentosAnteriores.stream().reduce("", String::concat));
                      repetido = true;
                  }

                  intentosAnteriores.add(intento);

                  //si la letra ingresada no esta duplicada, verifica si la letra esta en la palabra a adivinar 
                  if (!repetido) {
                      int veces = 0; //numero de veces en que la letra esta en la palabra
                      for (int i = 0; i < longitud; i++) {
                          if (palabraAdivinarChar[i] == intentoChar) {
                              nuevoarray[i] = intentoChar;  //reemplaza * con la letra que si esta en la palabra
                              correcto = true;
                              veces++;
                          }
                      }
                      if (correcto) {
                          System.out.println("La letra " + intentoChar + " se encuentra en la palabra secreta! Hay " + veces + " " + intentoChar + "'s en la palabra. Revelamos la letra(s): ");
                      } else {
                          System.out.println("Lo sentimos, La letra no esta en la palabra secreta. La palabra secreta es:  ");
                      }
                      System.out.println();
                  }
                  intentos2++;
                }
                System.out.println("Adivinaste toda la palabra " + palabraAdivinar.toUpperCase() + " correctamente! Te tomo " + intentos2 + " intentos!");

                System.out.println("\nPara retornar al menu ingresa 1");	
                menu=leer.nextInt();
            break;	
            case 3:
                System.out.println("\nDesarrollado por: \nKevin Maravilla Berrios\nEnrique Antonio Osorio Coto\nClaudia Vanessa Ramirez Aviles\nIsaac David Ramos Quintanilla\nCristopher Alonso Pinto Montalvo\nGuillermo Ernesto Ramirez Aguilar");
                System.out.println("\nPara retornar al menu ingresa 1");	
                menu=leer.nextInt();             
            break;            
            case 4:
                System.out.println("\nSe ha cerrado la sesion");
                intentos=0;
                menu=0;
                usuario="";
                clave="";
                incorrectos=3;
            break;
            case 5:
                System.exit(0);               
            break;                          
            default:
                System.out.println("Opcion no valida");
            break;
          }
        }
      }      
    } 
  }
}



