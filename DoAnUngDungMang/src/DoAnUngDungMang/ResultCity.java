/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DoAnUngDungMang;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ResultCity extends javax.swing.JFrame {

    /**
     * Creates new form Result
     */
    public ResultCity() {
        setupWindowListener();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ketquaThanhPho = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        ThongTinDiaLy = new javax.swing.JPanel();
        danso = new javax.swing.JLabel();
        toado = new javax.swing.JLabel();
        quocgia = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ThoiTiet = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        thoigian = new javax.swing.JLabel();
        uv = new javax.swing.JLabel();
        nhietdo = new javax.swing.JLabel();
        doam = new javax.swing.JLabel();
        newpapers = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(400, 130));

        title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        title.setText("KẾT QUẢ TÌM KIẾM:");

        ThongTinDiaLy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        danso.setText("Dân số:");

        toado.setText("Tọa độ: ");

        quocgia.setText("Quốc gia: ");

        title1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        title1.setText("THÔNG TIN ĐỊA LÝ:");

        jLabel1.setText("Vị trí: ");

        javax.swing.GroupLayout ThongTinDiaLyLayout = new javax.swing.GroupLayout(ThongTinDiaLy);
        ThongTinDiaLy.setLayout(ThongTinDiaLyLayout);
        ThongTinDiaLyLayout.setHorizontalGroup(
            ThongTinDiaLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongTinDiaLyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ThongTinDiaLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ThongTinDiaLyLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(ThongTinDiaLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(danso)
                            .addComponent(quocgia)
                            .addComponent(toado))))
                .addContainerGap(383, Short.MAX_VALUE))
        );
        ThongTinDiaLyLayout.setVerticalGroup(
            ThongTinDiaLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongTinDiaLyLayout.createSequentialGroup()
                .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quocgia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(danso)
                .addGap(0, 108, Short.MAX_VALUE))
        );

        ThoiTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        title2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        title2.setText("THỜI TIẾT HIỆN TẠI: ");

        thoigian.setText("Thời gian : ");

        uv.setText("Chỉ số UV :");

        nhietdo.setText("Nhiệt độ: ");

        doam.setText("Độ ẩm: ");

        javax.swing.GroupLayout ThoiTietLayout = new javax.swing.GroupLayout(ThoiTiet);
        ThoiTiet.setLayout(ThoiTietLayout);
        ThoiTietLayout.setHorizontalGroup(
            ThoiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThoiTietLayout.createSequentialGroup()
                .addComponent(title2)
                .addGap(0, 457, Short.MAX_VALUE))
            .addGroup(ThoiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ThoiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thoigian)
                    .addComponent(uv)
                    .addComponent(nhietdo)
                    .addComponent(doam))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThoiTietLayout.setVerticalGroup(
            ThoiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThoiTietLayout.createSequentialGroup()
                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thoigian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nhietdo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doam)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        newpapers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tiêu đề bài báo", "Đường dẫn"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("MỘT SỐ BÀI BÁO LIÊN QUAN:");

        javax.swing.GroupLayout newpapersLayout = new javax.swing.GroupLayout(newpapers);
        newpapers.setLayout(newpapersLayout);
        newpapersLayout.setHorizontalGroup(
            newpapersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newpapersLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(newpapersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        newpapersLayout.setVerticalGroup(
            newpapersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newpapersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ketquaThanhPhoLayout = new javax.swing.GroupLayout(ketquaThanhPho);
        ketquaThanhPho.setLayout(ketquaThanhPhoLayout);
        ketquaThanhPhoLayout.setHorizontalGroup(
            ketquaThanhPhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ketquaThanhPhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ketquaThanhPhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ketquaThanhPhoLayout.createSequentialGroup()
                        .addComponent(ThongTinDiaLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ThoiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(newpapers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ketquaThanhPhoLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 516, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ketquaThanhPhoLayout.setVerticalGroup(
            ketquaThanhPhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ketquaThanhPhoLayout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(ketquaThanhPhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ThongTinDiaLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThoiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newpapers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ketquaThanhPho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ketquaThanhPho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
     private void setupWindowListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Xử lý sự kiện đóng ở đây
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc chắn muốn thoát khỏi kết quả tìm kiếm này?", "Xác nhận thoát",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    Client1 x=new Client1();
                    x.setVisible(true);
                    dispose(); // Đóng cửa sổ (giải phóng tài nguyên)
                }
            }
        });
    }
    public void setThoiTiet(String diachi, String time, String csuv, String temper, String humidity ,String kinhdo, String vido){
        title.setText("KẾT QUẢ TÌM KIẾM: "+diachi);
        thoigian.setText("Thời gian đo đạt: "+time);
         uv.setText("Chỉ số UV :" + csuv);
         nhietdo.setText("Nhiệt độ: "+temper);
         doam.setText("Độ ẩm: "+humidity);
         toado.setText("Tọa độ: "+kinhdo+" độ Vĩ Bắc, "+vido+" độ Kinh Đông");
     }
        
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResultCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultCity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ThoiTiet;
    private javax.swing.JPanel ThongTinDiaLy;
    private javax.swing.JLabel danso;
    private javax.swing.JLabel doam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel ketquaThanhPho;
    private javax.swing.JPanel newpapers;
    private javax.swing.JLabel nhietdo;
    private javax.swing.JLabel quocgia;
    private javax.swing.JLabel thoigian;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel toado;
    private javax.swing.JLabel uv;
    // End of variables declaration//GEN-END:variables
}
