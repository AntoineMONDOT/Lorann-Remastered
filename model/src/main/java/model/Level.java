package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import contract.model.IElement;
import contract.model.ILevel;
import model.element.motionless.MotionlessElementFactory;

public class Level extends Observable implements ILevel {
    /** The width. */
    private int          width;

    /** The height. */
    private int          height;

    /** The on the level. */
    private IElement[][] onTheLevel;

    /**
     * Instantiates a new level with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the road is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    Level(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
    }

    /**
     * Loads file.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheLevel = new IElement[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheRoadXY(MotionlessElementFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }
    
    /* public void loadsMap(int idlevel){
	Map level = new Map(24,12);
	try {
		ResultSet result = BddWithGame.procedure("{call elementMap(?)}", idlevel);
		while(result.next()){
			int x = result.getInt("x");
			int y = result.getInt("y");
			int elementcaratere = result.getInt("elementcaractere");
			String url = result.getString("url");
			switch(elementcaractere){
			case 1: 
				level.addElement(new Bone(x, y,url),x,y);
				break;
			case 2:
				level.addElement(new HorizontalBone(x, y, url),x,y);
				break;
			case 3:
				level.addElement(new VerticalBone(x, y, url),x,y);
				break;
			case 4:
				level.addElement(new Crystal(x, y, url), x, y);
				break;
			case 6:
				IElement gate = new Gate(x, y, url);
				level.addElement(gate, x, y);
				break;
			case 7:
				level.setLorann(new Lorann(x, y,url));
				break;
			/*case 8: 
				level.addMobiles(new Monster1(x, y, url));
				break;
			case 9:
				level.addMobiles(new Monster2(x, y, url));
				break;
			case 10:
				level.addMobiles(new Monster3(x, y, url));
				break;
			case 11:
				level.addMobiles(new Monster4(x, y, url));
				break;
			case 12:
				level.addElement(new Purse(x, y, url), x, y);
				break;
			case 13:
				level.addElement(new Tile(x, y, url), x, y);
				break;
			}
		}
		maps.add(map);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}*/

    /**
     * get the width
     */
    @Override
    public final int getWidth() {
        return this.width;
    }

    /**
     * Sets the width.
     *
     * @param width
     *            the new width
     */
    private void setWidth(final int width) {
        this.width = width;
    }

    /**
     * get the height
     */
    @Override
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height
     *            the new height
     */
    private void setHeight(final int height) {
        this.height = height;
    }

    /**
     * get element by XY
     */
    @Override
    public final IElement getOnTheLevelXY(final int x, final int y) {
        return this.onTheLevel[x][y];
    }

    /**
     * Sets the on the level XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    private void setOnTheRoadXY(final IElement element, final int x, final int y) {
        this.onTheLevel[x][y] = element;
    }

    /**
     * Notify view of change
     */
    @Override
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Get the observable
     */
    @Override
    public Observable getObservable() {
        return this;
    }
}
