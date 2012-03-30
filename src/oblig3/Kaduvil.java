package oblig3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import oblig1.Circle;
import oblig1.GeoObject;
import oblig1.Rectangle;
import oblig1.Triangle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

public class Kaduvil {

	protected Shell shell;
	private GeoObject selectedObject;
	private ArrayList<GeoObject> list = new ArrayList<GeoObject>();
	private Button btnBeveg;
	private Slider slider;
	private Display display;
	private Canvas canvas;
	private int TIMER_INTERVAL = 100;
	Device device = Display.getCurrent();
	Color standardColor = getRandomColor();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Kaduvil window = new Kaduvil();
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

		new Thread() {
			public void run() {
				while(true) {
					if (display.isDisposed())
						break;
					try {
						Thread.sleep(TIMER_INTERVAL);
					} catch (Throwable th) {
					}
					if (display.isDisposed())
						return;
					display.asyncExec(new Runnable() {
						public void run() {
							if (canvas.isDisposed())
								return;
							canvas.redraw();
						}
					});
				}
			}
		}.start();

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
		shell.setLayout(new GridLayout(2, false));
		
				canvas = new Canvas(shell, SWT.NONE);
				canvas.setBounds(10, 10, 313, 242);
				canvas.addPaintListener(new PaintListener(){ 
					public void paintControl(PaintEvent e){ 
						org.eclipse.swt.graphics.Rectangle clientArea = shell.getClientArea(); 
						e.gc.drawLine(0,0,clientArea.width, clientArea.height);

						for(Iterator<GeoObject> i = list.iterator();i.hasNext();)
						{
							GeoObject o = i.next();
							updateMinSize(o);
							o.move(canvas.getSize().x, canvas.getSize().y);
							o.draw(e.gc);
						}
					}
				});
				canvas.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
				GridData gridData = new GridData();
				gridData.verticalAlignment = GridData.FILL;
				gridData.verticalSpan = 8;
				gridData.grabExcessVerticalSpace = true;
				gridData.horizontalAlignment = GridData.FILL;
				gridData.grabExcessHorizontalSpace = true;
				canvas.setLayoutData(gridData);
				
				// Listen for canvas clicks to see if a GeoObject was selected
				canvas.addListener(SWT.MouseDown, new Listener() {
					@Override
					public void handleEvent(Event e) {
						System.out.println("Clicked " + e.x + ":" + e.y);
						
						for(Iterator<GeoObject> i = list.iterator();i.hasNext();)
						{
							GeoObject o = i.next();
							if (o.select(e.x, e.y)) {
								System.out.println("Selected " + o.toString());
								selectedObject = o;
							}
						}
						
					}
				});
		
				Button btnFarge = new Button(shell, SWT.NONE);
				btnFarge.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						if (selectedObject != null)
						selectedObject.setColor(getRandomColor());
					}
				});
				btnFarge.setBounds(329, 10, 75, 25);
				btnFarge.setText("Farge");

		btnBeveg = new Button(shell, SWT.NONE);
		btnBeveg.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (selectedObject != null)
				selectedObject.setMovable(!selectedObject.isMovable());
				slider.setEnabled(selectedObject.isMovable());
			}
		});
		btnBeveg.setText("Beveg");
		btnBeveg.setBounds(329, 41, 75, 25);

		slider = new Slider(shell, SWT.NONE);
		slider.setPageIncrement(1);
		slider.setBounds(329, 72, 75, 17);
		slider.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (selectedObject != null)
				selectedObject.setSpeed(slider.getSelection());
			}
		});
				new Label(shell, SWT.NONE);
		
				Button btnSirkel = new Button(shell, SWT.NONE);
				btnSirkel.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						Random random = new Random();
						Point s = shell.getSize();
						int xMaxSize = (s.x/6);
						int yMaxSize = (s.y/6);
						int m = random.nextInt(yMaxSize)+1;
						Circle c;
						if(xMaxSize > yMaxSize)
						{
							c = new Circle(1, 1, true, standardColor, ((m)));
						}
						else 
						{
							//c = new Circle((random.nextInt(xMaxSize)+1)); 
							c = new Circle(1, 1, true, standardColor, ((random.nextInt(xMaxSize)+1)));
						}
						
						if (list.size() < 20)
							list.add(c);
					}
				});
				btnSirkel.setText("Sirkel");
				btnSirkel.setBounds(329, 219, 75, 25);
		
				Button btnFirkant = new Button(shell, SWT.NONE);
				btnFirkant.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent arg0) {				
						Random random = new Random();
						Point s = shell.getSize();
						int xMaxSize = (s.x/6);
						int yMaxSize = (s.y/6);						
						//Rectangle r = new Rectangle(((random.nextInt(xMaxSize)+1)),((random.nextInt(yMaxSize)+1)));
						Rectangle r = new Rectangle(1, 1, true, standardColor, ((random.nextInt(xMaxSize)+1)),((random.nextInt(yMaxSize)+1)));
						if (list.size() < 20)
							list.add(r);
					}
				});
				btnFirkant.setText("Firkant");
				btnFirkant.setBounds(329, 188, 75, 25);
				
						Button btnTrekant = new Button(shell, SWT.NONE);
						btnTrekant.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent arg0) {		
								Random random = new Random();
								Point s = shell.getSize();
								int xMaxSize = (s.x/6);
								int yMaxSize = (s.y/6);				
								//Triangle t = new Triangle(((random.nextInt(xMaxSize)+1)),((random.nextInt(yMaxSize)+1)));
								Triangle t = new Triangle(1, 1, true, standardColor, ((random.nextInt(xMaxSize)+1)),((random.nextInt(yMaxSize)+1)));
								if (list.size() < 20)
									list.add(t);
							}
						});
						btnTrekant.setText("Trekant");
						btnTrekant.setBounds(329, 157, 75, 25);
				new Label(shell, SWT.NONE);

	}
	
	protected void updateMinSize(GeoObject o) {
		Point min = shell.getMinimumSize();
		if (o.getWidth() > min.x)
			min.x = ((int) o.getWidth() * 4);
		if (o.getHeight() > min.y)
			min.y = ((int) o.getHeight() * 4);
		shell.setMinimumSize(min.x, min.y);
	}

	public Color getRandomColor()
	{
		Color temp;
		Random random = new Random();
		int r, g, b;
		r = random.nextInt(255);
		g = random.nextInt(255);
		b = random.nextInt(255);
		temp = new Color (device, r, g, b);		
		return temp;
	}
}
