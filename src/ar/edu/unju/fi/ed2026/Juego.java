
public class Juego {
	// codigo del juego
	Jugador[] jugadores;
	Mazo mazo;
	
    /**
     * Compara las cartas en juego en un turno.
     * @param cartas El arreglo de cartas que representa las cartas en juego.
     * @return la carta mayor, o null si hay empate.
     */
    public Carta comparaCartas(Carta[] cartas) {
        Carta ganadora = cartas[0];
        boolean hayEmpate = false;

        for (int i = 1; i < cartas.length; i++) {
            Carta actual = cartas[i];

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
}
