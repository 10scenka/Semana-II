package Models;

public class Papel extends Jugada{
    @Override
    public String comparar(Jugada oJugada) {
        if (oJugada instanceof Papel)
            return "Empate";
        else if (oJugada instanceof Piedra)
            return "Ganaste";
        else
            return "Perdiste";
    }
}
