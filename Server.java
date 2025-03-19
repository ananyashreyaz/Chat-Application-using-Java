import javax.swing.*; //importing for frame
import java.awt.*;
import javax.swing.border.*; 
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*; 
import java.text.*; 

public class Server implements ActionListener { 
    JTextField text;
    JPanel a1; 
    static Box vertical = Box.createVerticalBox(); 
    static JFrame f = new JFrame();   
    static DataOutputStream dos; 
    
    Server() {
        f.setLayout(null); 
        
        JPanel p1 = new JPanel(); //CREATING HEADER PANEL 
        p1.setBackground(Color.BLACK); //Setting the bg black for header
        p1.setBounds(0, 0, 450, 70); 
        p1.setLayout(null); 
        f.add(p1); 

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("3.png")); //adding the arrow image 
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT); //scaling it
        ImageIcon i3 = new ImageIcon(i2); //directly can't be used in JLabel so putting it under a third image 
        JLabel back = new JLabel(i3); 
        back.setBounds(5, 25, 25, 25); 
        p1.add(back); 

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("video.png")); //adding the video image 
        Image i6 = i5.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT); //scaling it
        ImageIcon i7 = new ImageIcon(i6); //directly can't be used in JLabel so putting it under a third image 
        JLabel vid = new JLabel(i7); 
        vid.setBounds(350, 30, 25, 15); 
        p1.add(vid);

        ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("phone.png")); //adding the phone image 
        Image i9 = i8.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT); //scaling it
        ImageIcon i11 = new ImageIcon(i9); //directly can't be used in JLabel so putting it under a third image 
        JLabel call = new JLabel(i11); 
        call.setBounds(300, 25, 25, 25); 
        p1.add(call); 

        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("3icon.png")); //adding the 3 dots image 
        Image i13 = i12.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT); //scaling it
        ImageIcon i14 = new ImageIcon(i13); //directly can't be used in JLabel so putting it under a third image 
        JLabel mo = new JLabel(i14); 
        mo.setBounds(400, 25, 5, 25); 
        p1.add(mo); 

        JLabel name = new JLabel("SERVER");
        name.setBounds(50, 25, 100, 18); //adding the name 
        name.setForeground(Color.WHITE); //setting the colour white
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);

        JLabel status = new JLabel("Active");
        status.setBounds(50, 45, 100, 18); //adding the status 
        status.setForeground(Color.WHITE); //setting the colour white
        status.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
        p1.add(status);

        a1 = new JPanel(); //texting area 
        a1.setBounds(5, 75, 440, 570);
        a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16)); 
        f.add(a1); 

        text = new JTextField(); //for typing
        text.setBounds(5, 655, 310, 40); 
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(text); 

        f.setUndecorated(true);

        JButton send = new JButton("Send"); 
        send.setBounds(320, 655, 123, 40); 
        send.setBackground(Color.BLACK);
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        send.addActionListener(this);
        f.add(send); 

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae){
                f.setVisible(false); // telling : on the occurrence of event close the frame
            }
        });

        f.setSize(450, 700); //setting the size for the chat room
        f.setLocation(200, 100); //setting the location in from x and y axis
        f.getContentPane().setBackground(Color.BLACK); //setting the bg colour black
        f.setVisible(true); //by default the chat room is not visible so setting it visible here
    }

    public void actionPerformed(ActionEvent ae) { //to get an action on clicking
        try {
            String out = text.getText(); 
            JPanel p2 = formatLabel(out); 
            a1.setLayout(new BorderLayout());
            JPanel right = new JPanel(new BorderLayout()); 
            right.add(p2, BorderLayout.LINE_END); //RIGHT SIDE TEXT BOX
            vertical.add(right); 
            vertical.add(Box.createVerticalStrut(15));
            a1.add(vertical, BorderLayout.PAGE_START); 
            text.setText("");
            dos.writeUTF(out);
            f.repaint();
            f.invalidate();
            f.validate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel(); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        JLabel output = new JLabel("<html> <p style=\"width: 150px\">" + out + "</p></html>"); 
        output.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        output.setBackground(Color.GRAY);
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        panel.add(output); 
        Calendar cal = Calendar.getInstance(); 
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); 
        JLabel time = new JLabel(); 
        time.setText(sdf.format(cal.getTime())); 
        panel.add(time); 
        return panel; 
    } 

    public static void main(String[] args) {
        new Server(); 
        try {
            ServerSocket skt = new ServerSocket(6001); 
            while (true) { //running an infinite loop to always accept the messages 
                Socket s = skt.accept(); 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                dos = new DataOutputStream(s.getOutputStream()); 
                while (true) {
                    String msg = dis.readUTF(); 
                    JPanel panel = formatLabel(msg); 
                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);     
                    vertical.add(left); 
                    f.validate(); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
