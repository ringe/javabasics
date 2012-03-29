package oblig3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import oblig1.Circle;
import oblig1.GeoObject;
import oblig1.Rectangle;
import oblig1.Triangle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class kaduvil {

	protected Shell shell;
	private GeoObject selectedObject;
	private ArrayList<GeoObject> list = new ArrayList<GeoObject>();
	private Button btnBeveg;
	private Slider slider;
	private Display display;
	private Canvas canvas;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			kaduvil window = new kaduvil();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	
	public void open() {
		
		display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		display.asyncExec(new Runnable() {
		    public void run() {
		    	try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    	display.asyncExec(new Runnable() {
		            public void run() {
		            	canvas.update();
		            	for(Iterator<GeoObject> i = list.iterator();i.hasNext();)
		            	{
		            		GeoObject o = i.next();
		            		o.;
		            	}
		            	
		            }
		        });
		    }
		});
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		 
		
		canvas = new Canvas(shell, SWT.NONE);
		canvas.setBounds(10, 10, 313, 242);
		canvas.addPaintListener(new PaintListener(){ 
	        public void paintControl(PaintEvent e){ 
	        	org.eclipse.swt.graphics.Rectangle clientArea = shell.getClientArea(); 
	        	e.gc.drawLine(0,0,clientArea.width,clientArea.height);
	        	for(Iterator<GeoObject> i = list.iterator();i.hasNext();)
            	{
            		GeoObject o = i.next();
            		o.draw(e.gc);
            	}
	        } 
	    });
		
		Button btnFarge = new Button(shell, SWT.NONE);
		btnFarge.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				selectedObject.setColor(Color.blue);
			}
		});
		btnFarge.setBounds(329, 10, 75, 25);
		btnFarge.setText("Farge");
		
		btnBeveg = new Button(shell, SWT.NONE);
		btnBeveg.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				boolean b = selectedObject.isMovable();
				selectedObject.setMovable(!b);
			}
		});
		btnBeveg.setText("Beveg");
		btnBeveg.setBounds(329, 41, 75, 25);
		
		slider = new Slider(shell, SWT.NONE);
		slider.setPageIncrement(1);
		slider.setBounds(329, 72, 75, 17);
		slider.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		        btnBeveg.setText(new Integer(slider.getSelection()).toString());
		        //selectedObject.setSpeed(slider.getSelection());
		      }
		    });
		
		Button btnTrekant = new Button(shell, SWT.NONE);
		btnTrekant.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {		
				Random random = new Random();
				int xMaxSize = (1/6*shell.getSize().x);
				int yMaxSize = (1/6*shell.getSize().y);				
				Triangle t = new Triangle(((random.nextInt(xMaxSize)+1)),((random.nextInt(yMaxSize)+1)));
				list.add(t);
				
				
			}
		});
		btnTrekant.setText("Trekant");
		btnTrekant.setBounds(329, 157, 75, 25);
		
		Button btnFirkant = new Button(shell, SWT.NONE);
		btnFirkant.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {				
				Random random = new Random();
				int xMaxSize = (1/6*shell.getSize().x);
				int yMaxSize = (1/6*shell.getSize().y);				
				Rectangle r = new Rectangle(((random.nextInt(xMaxSize)+1)),((random.nextInt(yMaxSize)+1)));
				list.add(r);
			}
		});
		btnFirkant.setText("Firkant");
		btnFirkant.setBounds(329, 188, 75, 25);
		
		Button btnSirkel = new Button(shell, SWT.NONE);
		btnSirkel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Random random = new Random();
				int xMaxSize = (1/6*shell.getSize().x);
				int yMaxSize = (1/6*shell.getSize().y);
				Circle c;
				if(xMaxSize > yMaxSize)
				{
					c = new Circle((random.nextInt(yMaxSize)+1)); 
				}
				else 
				{
					c = new Circle((random.nextInt(xMaxSize)+1)); 
				}
				
				list.add(c);
			}
		});
		btnSirkel.setText("Sirkel");
		btnSirkel.setBounds(329, 219, 75, 25);

	}
	
}
