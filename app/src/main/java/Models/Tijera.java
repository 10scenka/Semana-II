package Models;

public class Tijera extends Jugada{
    @Override
    public String comparar(Jugada oJugada) {
        if (oJugada instanceof Tijera)
            return "Empate";
        else if (oJugada instanceof Piedra)
            return "Perdiste";
        else
            return "Ganaste";
    }
}
