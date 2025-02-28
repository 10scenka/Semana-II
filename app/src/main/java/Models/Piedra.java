package Models;

public class Piedra extends Jugada{
    @Override
    public String comparar(Jugada oJugada) {
        if (oJugada instanceof Papel)
            return "Perdiste";
        else if (oJugada instanceof Piedra)
            return "Empate";
        else
            return "Ganaste";
    }
}
