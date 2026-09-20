import ar.edu.unju.fi.ed2026.Helper.*;

public class Juego {
	// codigo del juego
	Jugador[] jugadores;
	Mazo mazo;
	
	public Juego() {
		this.jugadores = cargarJugadores();
		this.mazo = new Mazo();
        int opcion;
        do{
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    System.out.println("Opción no contemplada. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4) ;
	}
	
	private cargarJugadores() {
		
	}
	
	private Jugador cargarJugador(String nombre, String apellido) {
		
		return jugador;
	}
	
    /**
     * Compara las cartas en juego en un turno.
     * @param cartas El arreglo de cartas que representa las cartas en juego.
     * @return la carta mayor, o null si hay empate.
     */
    public Carta comparaCartas(Jugador[] jugadores) {
        Carta ganadora = jugadores[0].getCartaEnMano();
        boolean hayEmpate = false;

        for (int i = 1; i < jugadores.length; i++) {
            Carta actual = jugadores[i].getCartaEnMano();

            if (actual.getValor() > ganadora.getValor()) {
                ganadora = actual;
                hayEmpate = false; 
                
            } else if (actual.getValor() == ganadora.getValor()) {
                hayEmpate = true; 
            }
        }
        if (hayEmpate) {
            return null;
        }
        return ganadora;
    }
    
    
    private void repartirCartas (Jugador[] jugadores, Mazo mazo) {
    	for (Jugador actual : jugadores) {
    		actual.setCartaEnMano(mazo.extraerCarta());
    	}
    }

    private int mostrarMenu() {

        System.out.println("\n=====================================");
        System.out.println("  PROYECTO INTEGRADOR I - JUEGO DE CARTAS");
        System.out.println("=====================================");
        System.out.println("1. Registrar / Configurar Jugadores (4)");
        System.out.println("2. Iniciar Partida (Jugar Rondas)");
        System.out.println("3. Ver Reglas del Juego");
        System.out.println("4. Salir");
        return Helper.nextInteger("Ingrese una opción: ", "Debe ingresar un número.");
    
    }

}
