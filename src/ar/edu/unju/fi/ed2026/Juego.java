
import java.util.Scanner;

public class Juego {
	// codigo del juego
	Jugador[] jugadores;
	Mazo mazo;
	
	public Juego() {
		
		this.jugadores = cargarJugadores();
		this.mazo = new Mazo();
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
}
