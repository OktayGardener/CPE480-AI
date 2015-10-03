import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import java.io.File;

/** 
 Simple harness for testing GUI code.
 
 <P>To use this class, edit the code to suit your needs.  
*/
public final class MinimalSwingApplication {
  private File file;
	
  public static void main(String... aArgs){
    MinimalSwingApplication app = new MinimalSwingApplication();
    app.buildAndDisplayGui();
  }
  
  // PRIVATE

  private void buildAndDisplayGui(){
    JFrame frame = new JFrame("~the gui~"); 
    buildContent(frame);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
  
  private void buildContent(JFrame aFrame){
    final JPanel panel = new JPanel();
    panel.add(new JLabel("Calculate GC content!"));
    
    final JTextField windowSize = new JTextField("Insert window size");
    windowSize.setHorizontalAlignment(JTextField.CENTER);
    windowSize.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
            windowSize.setText("");
        }
    });

    final JTextField stepSize = new JTextField("Insert step size");
    stepSize.setHorizontalAlignment(JTextField.CENTER);
    stepSize.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
            stepSize.setText("");
        }
    });
    
    panel.add(windowSize);
    panel.add(stepSize);
    
    JButton btnFile = new JButton("Select Excel File");
    btnFile.addActionListener(new ActionListener() {
        final JFrame frame = new JFrame("Hello");
        //Handle open button action.
        public void actionPerformed(ActionEvent e) {
            final JFileChooser fc = new JFileChooser(); 
            int returnVal = fc.showOpenDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                //This is where a real application would open the file.
                System.out.println("File: " + file.getName() + ".");    
            } else {
                System.out.println("Open command cancelled by user.");
            }
            System.out.println(returnVal);
        }
    });
    panel.add(btnFile);
    
    JButton ok = new JButton("Calculate!");
    ok.addActionListener(new ShowDialog(aFrame));
    panel.add(ok);
    
    aFrame.getContentPane().add(panel);
  }
  
  public void chosenFile(){
	  System.out.println("lol");
  }
  
  private static final class ShowDialog implements ActionListener {
    ShowDialog(JFrame aFrame){
      fFrame = aFrame;
    }
    
    @Override public void actionPerformed(ActionEvent aEvent) {
      JOptionPane.showMessageDialog(fFrame, "Success! The file is outputed as out.txt");
    }
    private JFrame fFrame;
  }
}
 