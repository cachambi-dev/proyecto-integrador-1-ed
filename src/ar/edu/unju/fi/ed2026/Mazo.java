package ar.edu.unju.fi.ed2026;

import ar.edu.unju.fi.ed2026.utils.CartaUils;

public class Mazo {
    private MiStack pilaCartas;

    public Mazo() {
        this.pilaCartas = new MiStack(52);
        inicializarYApilarMazo();
    }

    private void inicializarYApilarMazo() {
        Carta[] cartasAleatorias = generarMazoFrancesAleatorio();

        for (Carta carta : cartasAleatorias) {
            if (carta != null) {
                pilaCartas.push(carta);
            }
        }
    }


    private Carta[] generarMazoFrancesAleatorio() {
        Carta[] cartasBase = new Carta[52];
        String[] palos = {"Trébol", "Pica", "Corazones", "Diamantes"};
        int index = 0;

        // Generamos las 52 cartas base ordenadas
        for (String palo : palos) {
            for (int valor = 1; valor <= 13; valor++) {
                cartasBase[index] = new Carta(palo, valor, true);
                index++;
            }
        }

        // Las mezclamos en un mazo aleatorio
        Carta[] mazoAleatorio = new Carta[52];
        int posicion = 0;

        while (posicion < 52) {
            int indiceAleatorio = CartaUils.generarIndiceAleatorio(); // 0 a 51
            Carta cartaSeleccionada = cartasBase[indiceAleatorio];

            if (!cartaYaExisteEnMazo(mazoAleatorio, cartaSeleccionada)) {
                mazoAleatorio[posicion] = cartaSeleccionada;
                posicion++;
            }
        }

        return mazoAleatorio;
    }

    private boolean cartaYaExisteEnMazo(Carta[] mazo, Carta cartaBuscada) {
        for (Carta c : mazo) {
            if (c != null && c.getPalo().equals(cartaBuscada.getPalo()) && c.getValor() == cartaBuscada.getValor()) {
                return true;
            }
        }
        return false;
    }

    //Reparte una carta del mazo a cada uno de los jugadores.
    public void repartirCartasAJugadores(Jugador[] jugadores) {
    for (Jugador jugador : jugadores) {
        if (!estaVacio()) {
            Carta cartaExtraida = sacarYMostrarCarta(); // Hace el pop() de MiStack
            jugador.setCartaEnMano(cartaExtraida);
        } else {
            System.out.println("[Aviso] No hay suficientes cartas en el mazo.");
        }
    }
}

    public Carta sacarYMostrarCarta() {
        if (pilaCartas.isEmpty()) {
            System.out.println("[Aviso] El mazo se ha quedado sin cartas.");
            return null;
        }

        Carta cartaExtraida = pilaCartas.pop();
        System.out.println("Carta extraída del mazo: " + cartaExtraida.toString());
        return cartaExtraida;
    }

    public boolean estaVacio() {
        return pilaCartas.isEmpty();
    }

    public int cartasRestantes() {
        return pilaCartas.size();
    }
}