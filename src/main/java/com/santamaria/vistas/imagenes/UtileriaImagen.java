package recursos.imagenes;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;

public class UtileriaImagen {

    public static void imagenLbl(String imagePath, JLabel label) {
        String userDir = System.getProperty("user.dir");
        String imageFullPath = userDir + "\\src\\main\\java\\recursos\\imagenes\\" + imagePath;
        Image img = Toolkit.getDefaultToolkit().getImage(imageFullPath);
        label.setIcon(new ImageIcon(img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
    }

    public static void iconoFrame(String imagePath, JFrame frame) {
        String userDir = System.getProperty("user.dir");
        String imageFullPath = userDir + "\\src\\main\\java\\recursos\\imagenes\\" + imagePath;
        Image img = Toolkit.getDefaultToolkit().getImage(imageFullPath);
        frame.setIconImage(img);
    }

    public static void imagenBtn(String imagePath, JButton button) {
        String userDir = System.getProperty("user.dir");
        String imageFullPath = userDir + "\\src\\main\\java\\recursos\\imagenes\\" + imagePath;
        Image img = Toolkit.getDefaultToolkit().getImage(imageFullPath);
        button.setIcon(new ImageIcon(img.getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH)));
    }

    public static void imagenPnl(String imagePath, JPanel panel) {
        String userDir = System.getProperty("user.dir");
        String imageFullPath = userDir + "\\src\\main\\java\\recursos\\imagenes\\" + imagePath;
        Image img = Toolkit.getDefaultToolkit().getImage(imageFullPath);
        ImageIcon icon = new ImageIcon(img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH));
        JLabel label = new JLabel(icon);

        panel.removeAll(); // Limpia cualquier contenido anterior del panel
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER); // Agrega la imagen al centro del panel
        panel.setOpaque(false);
        panel.setBorder(null);
    }
}
