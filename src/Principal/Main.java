package Principal;

import Controlador.ControladorFormaPaci;
import Vista.FormaPaci;

public class Main {

    public static void main(String[] args) {
   Vista.FormaPaci fp = new Vista.FormaPaci();
        new Controlador.ControladorFormaPaci(fp);
        fp.setVisible(true);
    }
    
}
