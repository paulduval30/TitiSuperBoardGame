package fr.paulduval30.titisuperboardgame.engine;

import fr.paulduval30.titisuperboardgame.utils.ArrayUtils;

import java.awt.*;
import java.text.AttributedCharacterIterator;

public class GameGraphics
{
	private Camera camera;
	private Graphics2D g;
	
	public GameGraphics(Camera camera, Graphics2D g)
	{
		this.camera = camera;
		this.g = g;
		this.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	public void drawRect(float x, float y, float width, float height)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.drawRect((int) x, (int) y, (int) width, (int) height);
	}

	public void setColor(Color color)
	{
		this.g.setColor(color);
	}

	public void fillRect(float x, float y, float width, float height)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.fillRect((int) x, (int) y, (int) width, (int) height);
	}

	public void drawOval(float x, float y, float width, float height)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.drawOval((int) x, (int) y, (int) width, (int) height);
	}

	public void fillOval(float x, float y, float width, float height)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.fillOval((int) x, (int) y, (int) width, (int) height);
	}

	public void drawImage(Image image, float x, float y)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.drawImage(image, (int) x, (int) y, null);
	}

	public void drawImage(Image image, float x, float y, float width, float height, Color bgColor)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.drawImage(image, (int) x, (int) y, (int) width, (int) height,  bgColor, null);
	}

	public void drawImage(Image image, float x, float y, float width, float height)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.drawImage(image, (int) x, (int) y, (int) width, (int) height, null);
	}

	public void drawPolygon(float[] xPoints, float[] yPoints, int nPoints)
	{
		int[] ixPoints = new int[xPoints.length];
		int[] iyPoints = new int[yPoints.length];

		for(int i = 0; i < xPoints.length; i++)
			ixPoints[i] =(int)(xPoints[i] + this.camera.getX());

		for(int i = 0; i < yPoints.length; i++)
			iyPoints[i] = (int)(yPoints[i] + this.camera.getY());

		this.g.drawPolygon(ixPoints, iyPoints, nPoints);
	}

	public void drawPolygon(Polygon poly)
	{
		float[] xPoints = ArrayUtils.intToFloat1D(poly.xpoints);
		float[] yPoints = ArrayUtils.intToFloat1D(poly.ypoints);
		int nPoints = poly.npoints;
		this.drawPolygon(xPoints, yPoints, nPoints);
	}

	public void drawImage(Image image, float x, float y, Color bgColor)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.drawImage(image, (int) x, (int) y, bgColor, null);
	}

	public void drawString(String str, float x, float y)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.drawString(str, (int) x, (int) y);
	}

	public void drawString(AttributedCharacterIterator iterator, float x, float y)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.drawString(iterator, (int) x, (int) y);
	}

	public void drawArc(float x, float y, float width, float height, float startAngle, float arcAngle)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.drawArc((int) x, (int) y, (int) width, (int) height, (int) startAngle, (int) arcAngle);
	}

	public void fillArc(float x, float y, float width, float height, float startAngle, float arcAngle)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.fillArc((int) x, (int) y, (int) width, (int) height, (int) startAngle, (int) arcAngle);
	}

	public void drawRoundRect(float x, float y, int width, int height, int arcWidth, int arcHeight)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.drawRoundRect((int) x, (int) y, width, height, arcWidth, arcHeight);
	}

	public void fillRoundRect(float x, float y, int width, int height, int arcWidth, int arcHeight)
	{
		x += this.camera.getX();
		y += this.camera.getY();
		this.g.fillRoundRect((int) x, (int) y, width, height, arcWidth, arcHeight);
	}

	public void setFont(Font font)
	{
		this.g.setFont(font);
	}

	public FontMetrics getFontMetrics()
	{
		return this.g.getFontMetrics();
	}

	public void drawImage(Image img, float dx1, float dy1, float dx2, float dy2, float sx1, float sy1, float sx2,
						  float sy2, Color bgcolor)
	{
		// TODO
		//throw new NotImplementedException();
	}

	public void drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2)
	{
		// TODO
		//throw new NotImplementedException();
	}

	public void drawLine(float x1, float y1, float x2, float y2)
	{
		x1 += this.camera.getX();
		y1 += this.camera.getY();
		x2 += this.camera.getX();
		y2 += this.camera.getY();
		this.g.drawLine((int) x1,(int) y1,(int) x2,(int) y2);
	}

	public Color getColor()
	{
		return this.g.getColor();
	}
}
