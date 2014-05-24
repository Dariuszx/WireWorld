/*
 * Created by JFormDesigner on Sat May 24 17:58:36 CEST 2014
 */

package GUI.zapiszPlik;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Dariusz Dybka
 */
public class ZapiszPlik extends JFileChooser {

    public ZapiszPlik() {

        initComponents();

        FileNameExtensionFilter filtr = new FileNameExtensionFilter( "Pliki typu .stk", "stk" );
        this.setFileFilter( filtr );
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dariusz Dybka
        setDialogType(JFileChooser.SAVE_DIALOG);
        //---- this ----
        setDialogTitle("Zapisz generacj\u0119.");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dariusz Dybka
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
