/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigmonitor;

import pigmonitor.control.ControlEnfermedad;
import pigmonitor.modelo.ConsultarEnfermedad;
import pigmonitor.modelo.Enfermedad;
import pigmonitor.vista.Vista;

/**
 *
 * @author pcorream
 */
public class PigMonitor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Enfermedad enfe = new Enfermedad(); 
        ConsultarEnfermedad enfeC = new ConsultarEnfermedad();
        Vista vista = new Vista();
        
        ControlEnfermedad ctrlE = new ControlEnfermedad(enfe, enfeC, vista);
        ctrlE.iniciarEnfermedad();
        vista.setVisible(true);
        
        
    }
    
}
