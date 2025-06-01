package _1ms.jmm.jmcmodmgr;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class ItemBox extends VBox {
    public ItemBox(String imgUrl, String title, String desc) {
        var view = new ImageView(loadWebP(imgUrl));

       view.setFitWidth(96);
       view.setFitHeight(96);
       view.setPreserveRatio(true);

        var clip = new Rectangle(96, 96);
        clip.setArcWidth(16);   // try 16 or 20 for a noticeable roundness
        clip.setArcHeight(16);
        view.setClip(clip);

        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Segoe UI", 15));
        titleLabel.setTextFill(Color.WHITE);

        Label descLabel = new Label(desc);
        descLabel.setFont(Font.font("Segoe UI", 12));
        descLabel.setTextFill(Color.LIGHTGRAY);

        VBox textBox = new VBox(titleLabel, descLabel);
        textBox.setSpacing(2);

        HBox itemBox = new HBox(view, textBox);
        itemBox.setPadding(new Insets(10));
        itemBox.setSpacing(10);
        itemBox.setAlignment(Pos.CENTER_LEFT);
        itemBox.setBackground(new Background(new BackgroundFill(Color.web("#1e1e2e"), new CornerRadii(6), Insets.EMPTY)));
        itemBox.setMaxWidth(500);
        itemBox.setMinHeight(100);

        itemBox.setOnMouseEntered(e -> itemBox.setBackground(new Background(new BackgroundFill(Color.web("#2c2c3c"), new CornerRadii(6), Insets.EMPTY))));
        itemBox.setOnMouseExited(e -> itemBox.setBackground(new Background(new BackgroundFill(Color.web("#1e1e2e"), new CornerRadii(6), Insets.EMPTY))));
        getChildren().add(itemBox);
        setAlignment(Pos.CENTER);

    }

    private static Image loadWebP(String webpUrl) {//TODO Cache
        //Might need to reg?
        //ImageIO.scanForPlugins();

        try (InputStream in = new URI(webpUrl).toURL().openStream()) {
            //Let ImageIO (with the WebP plugin) decode into a BufferedImage
            BufferedImage buff = ImageIO.read(in);
            if (buff == null)
                throw new IllegalArgumentException("Could not decode WebP image from URL: " + webpUrl);

            int w = buff.getWidth();
            int h = buff.getHeight();

            //Create a JavaFX WritableImage of the same size
            WritableImage fxImage = new WritableImage(w, h);
            PixelWriter pw = fxImage.getPixelWriter();

            //Grab all ARGB pixels from the BufferedImage into an int[] buffer
            //NOTE: getRGB returns TYPE_INT_ARGB pixels in Java’s 0xAARRGGBB format
            int[] argbPixels = new int[w * h];
            buff.getRGB(0, 0, w, h, argbPixels, 0, w);

            //Copy them into the WritableImage using an IntArgb PixelFormat
            pw.setPixels(
                    0, 0,           // destination x, y
                    w, h,           // width, height
                    PixelFormat.getIntArgbInstance(),
                    argbPixels,
                    0,              // array offset
                    w               // scanline stride
            );
            return fxImage;
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
