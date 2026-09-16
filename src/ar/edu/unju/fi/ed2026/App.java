package ar.edu.unju.fi.ed2026;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        Jugador[] jugadores = new Jugador[4];
        boolean jugadoresRegistrados = false;

        do {
            System.out.println("\n========================================");
            System.out.println("   PROYECTO INTEGRADOR I - JUEGO DE CARTAS");
            System.out.println("========================================");
            System.out.println("1. Registrar / Configurar Jugadores (4)");
            System.out.println("2. Iniciar Partida (Jugar Rondas)");
            System.out.println("3. Ver Reglas del Juego");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- REGISTRO DE JUGADORES ---");
                        for (int i = 0; i < jugadores.length; i++) {
                            System.out.println("\nDatos para el Jugador " + (i + 1) + ":");

                            // VALIDACIÓN DE NOMBRE
                            String nombre = "";
                            while (true) {
                                System.out.print("Ingrese nombre (solo letras): ");
                                nombre = scanner.nextLine().trim();
                                // Verificamos que no esté vacío y que solo contenga letras (incluyendo tildes y espacios)
                                if (!nombre.isEmpty() && nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                                    break;
                                }
                                System.out.println("[Error] El nombre no puede contener números, símbolos ni estar vacío. Intente nuevamente.");
                            }

                            //  VALIDACIÓN DE APELLIDO
                            String apellido = "";
                            while (true) {
                                System.out.print("Ingrese apellido (solo letras): ");
                                apellido = scanner.nextLine().trim();
                                if (!apellido.isEmpty() && apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                                    break;
                                }
                                System.out.println("[Error] El apellido no puede contener números, símbolos ni estar vacío. Intente nuevamente.");
                            }

                            // --- VALIDACIÓN DE EDAD ---
                            int edad = 0;
                            while (true) {
                                System.out.print("Ingrese edad (entero mayor a 0): ");
                                if (scanner.hasNextInt()) {
                                    edad = scanner.nextInt();
                                    scanner.nextLine();
                                    if (edad > 0) {
                                        break;
                                    } else {
                                        System.out.println("[Error] La edad debe ser un número mayor a 0.");
                                    }
                                } else {
                                    System.out.println("[Error] Debe ingresar un número entero válido.");
                                    scanner.next();
                                    scanner.nextLine();
                                }
                            }

                            jugadores[i] = new Jugador();
                            jugadores[i].cargarNombreyapellido(nombre, apellido);
                            jugadores[i].cargarEdad(edad);
                        }

                        jugadoresRegistrados = true;
                        System.out.println("\n¡Los 4 jugadores han sido registrados con éxito en el arreglo!");

                        // Mostramos los jugadores cargados para verificar
                        System.out.println("\n--- LISTA DE PARTICIPANTES ---");
                        for (Jugador j : jugadores) {
                            System.out.println(j.toString());
                        }
                        break;

                    case 2:
                        if (!jugadoresRegistrados) {
                            System.out.println("\n[Atención] Primero debe registrar a los 4 jugadores (Opción 1).");
                        } else {
                            System.out.println("\n>> Creando Mazo y la Pila...");

                            Mazo mazoPrueba = new Mazo();

                            System.out.println("¡Mazo creado con éxito! Cartas totales en la pila: " + mazoPrueba.cartasRestantes());
                            System.out.println("\n--- Simulando extracción de cartas para los 4 jugadores ---");

                            // Probamos sacar 4 cartas (una para cada jugador registrado)
                            for (int i = 0; i < 4; i++) {
                                System.out.print("Jugador " + (i + 1) + " -> ");
                                mazoPrueba.sacarYMostrarCarta();
                            }

                            System.out.println("\nCartas restantes en la pila: " + mazoPrueba.cartasRestantes());
                        }
                        break;

                    case 3:
                        System.out.println("\n--- REGLAS ---");
                        System.out.println("Cuatro jugadores toman naipes de un mazo.");
                        System.out.println("El de mayor valor numérico (1-13) gana las cartas de la ronda.");
                        System.out.println("En empate, cada uno conserva su carta. Gana el de mayor puntaje acumulado.");
                        break;

                    case 4:
                        System.out.println("\n¡Gracias por usar el programa! Saliendo...");
                        break;

                    default:
                        System.out.println("\n[Error] Opción no válida. Ingrese un número del 1 al 4.");
                }
            } else {
                System.out.println("\n[Error] Debe ingresar un valor numérico válido.");
                scanner.next(); // Limpiar entrada incorrecta
            }

        } while (opcion != 4);

        scanner.close();
    }
    }

