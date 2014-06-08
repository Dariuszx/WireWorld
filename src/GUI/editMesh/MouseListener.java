package GUI.editMesh;

import Data.Mesh;
import Data.Parameters;
import Modules.ErrorHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;


public class MouseListener implements java.awt.event.MouseListener {

    private JButton buttonPressed;
    private Mesh mesh;
    private Canvas canvas;


    public MouseListener( Mesh mesh, Canvas canvas ) {

        this.mesh = mesh;
        this.canvas = canvas;
    }

    public void setButtonPressed( JButton buttonPressed ) { this.buttonPressed = buttonPressed; }

    @Override
    public void mouseClicked( MouseEvent mouseEvent ) {

        if ( editMesh( getMeshCoordinates( mouseEvent.getX(), mouseEvent.getY() ) ) )
        {
            canvas.repaint();
        }

    }

    @Override
    public void mousePressed( MouseEvent mouseEvent ) {

    }

    @Override
    public void mouseReleased( MouseEvent mouseEvent ) {

    }

    @Override
    public void mouseEntered( MouseEvent mouseEvent ) {

    }

    @Override
    public void mouseExited( MouseEvent mouseEvent ) {

    }

    private Dimension getMeshCoordinates( int x1, int y1 ) {

        int x = (x1 + 1) / 11;
        int y = (y1 + 1) / 11;

        if( x < mesh.getNumberOfColumns() && y < mesh.getNumberOfRows() ) {

            return new Dimension( x, y );
        } else return null;
    }

    private boolean editMesh( Dimension dim ) {

        if( dim == null ) return false;

        try
        {
            if ( buttonPressed.getText().equals( "Głowa" ) )
            {
                mesh.setSpecifiedCellType( dim, "head" );
            }
            else if( buttonPressed.getText().equals( "Przewodnik" ) )
            {
                mesh.setSpecifiedCellType( dim, "conductor" );
            }
            else if( buttonPressed.getText().equals( "Ogon" ) )
            {
                mesh.setSpecifiedCellType( dim, "tail" );
            }
            else if( buttonPressed.getText().equals("Pusta") )
            {
                mesh.setSpecifiedCellType( dim, "empty" );
            }
            else if( buttonPressed.getText().equals("Diode") )
            {
                mesh.setSpecifiedCellType( dim, "diode" );
            }
            else if( buttonPressed.getText().equals("XOR") )
            {
                mesh.setSpecifiedCellType( dim, "xor" );
            }
        }
        catch ( ErrorHandling errorHandling )
        {
            return false;
        }
        return true;
    }
}
