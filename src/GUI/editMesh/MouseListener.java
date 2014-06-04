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
                mesh.setCondition(dim, 1);
            }
            else if( buttonPressed.getText().equals( "Przewodnik" ) )
            {
                mesh.setCondition(dim, 3);
            }
            else if( buttonPressed.getText().equals( "Ogon" ) )
            {
                mesh.setCondition(dim, 2);
            }
            else if( buttonPressed.getText().equals("Pusta") )
            {
                mesh.setCondition(dim, 0);
            }
            else if( buttonPressed.getText().equals("Diode") )
            {
                drawDiode( dim );
            }
            else if( buttonPressed.getText().equals("XOR") )
            {
                drawXor( dim );
            }
        }
        catch ( ErrorHandling errorHandling )
        {
            return false;
        }
        return true;
    }

    private void drawDiode( Dimension dim ) {

        try {

            mesh.setCondition( dim, 3 );
            mesh.setCondition( dim.width, dim.height - 1, 3 );
            mesh.setCondition( dim.width, dim.height - 2, 3 );
            mesh.setCondition( dim.width + 1, dim.height, 3 );
            mesh.setCondition( dim.width + 1, dim.height - 2, 3 );

        } catch( ErrorHandling e ) {

        }
    }

    private void drawXor( Dimension dim ) {

        try {

            mesh.setCondition( dim, 3 );
            mesh.setCondition( dim.width, dim.height - 6, 3 );

            mesh.setCondition( dim.width + 1, dim.height, 3 );
            mesh.setCondition( dim.width + 1, dim.height - 2, 3 );
            mesh.setCondition( dim.width + 1, dim.height - 3, 3 );
            mesh.setCondition( dim.width + 1, dim.height - 4, 3 );
            mesh.setCondition( dim.width + 1, dim.height - 6, 3 );

            mesh.setCondition( dim.width + 2, dim.height - 1, 3 );
            mesh.setCondition( dim.width + 2, dim.height - 2, 3 );
            mesh.setCondition( dim.width + 2, dim.height - 4, 3 );
            mesh.setCondition( dim.width + 2, dim.height - 5, 3 );

            mesh.setCondition( dim.width + 3, dim.height - 2, 3 );
            mesh.setCondition( dim.width + 3, dim.height - 4, 3 );

            mesh.setCondition( dim.width + 4, dim.height - 2, 3 );
            mesh.setCondition( dim.width + 4, dim.height - 3, 3 );
            mesh.setCondition( dim.width + 4, dim.height - 4, 3 );

            mesh.setCondition( dim.width + 5, dim.height - 3, 3 );
            mesh.setCondition( dim.width + 6, dim.height - 3, 3 );

        } catch( ErrorHandling e ) {

        }

    }
}
