public interface Salida {

    default String agregarEspacio(String cambio) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < cambio.length(); i++) {
            if (cambio.charAt(i) == '_') {
                resultado.append(' ');
            } else {
                resultado.append(cambio.charAt(i));
            }
        }
        return resultado.toString();
    }

    default String quitarEspacio(String cambio) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < cambio.length(); i++) {
            if (cambio.charAt(i) == ' ') {
                resultado.append('_');
            } else {
                resultado.append(cambio.charAt(i));
            }
        }
        return resultado.toString();
    }
}
