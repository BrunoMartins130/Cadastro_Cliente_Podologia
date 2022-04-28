/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import JDBC.AnamneseDao;
import java.util.Date;
import JDBC.ClientesDao;
import JDBC.VistaDorsalDao;
import JDBC.VistaPlantarDao;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import javabeans.Anamnese;
import javabeans.Clientes;
import javabeans.VistaDorsal;
import javabeans.VistaPlantar;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author BRUNO
 */
public final class TelaCadastroCliente extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroCliente1
     */
    //TEM COMO PARAMETRO DE ENTRADA DESSA INTERFACE UM OBJETO DO TIPO CLIENTE
    //ENTAO APOS ABIR ESSA TELA CONSULTA A ANAMNESE DESSE CLIENTE E SETA NOS CAMPOS........
    public TelaCadastroCliente(Clientes clientes) {

        initComponents();

        txtId.setText(String.valueOf(clientes.getId()));
        txtNome.setText(clientes.getNome());
        txtCpf.setText(clientes.getCpf());
        txtRg.setText(clientes.getRg());
        txtNascimento.setText(clientes.getNascimento());
        txtCep.setText(clientes.getCep());
        txtEndereco.setText(clientes.getEndereco());
        txtNumero.setText(String.valueOf(clientes.getNumero()));
        jComboBoxUf.setSelectedItem(clientes.getUf());
        txtBairro.setText(clientes.getBairro());
        txtCidade.setText(clientes.getCidade());
        txtTelefone.setText(clientes.getTelefone());
        txtCelular.setText(clientes.getCelular());
        txtEmail.setText(clientes.getEmail());
        txtObservacao.setText(clientes.getObservacao());

        //chamada do metodo com o paramentro id do cliente que esta 
        //como paramentro de entrada a interface
        pegarDadosAnamneseCliente(clientes.getId());
        carregarVistaPlantar(clientes.getId());
        carregarVistaDorsal(clientes.getId());
       
    }

    //metodo que recebe como paramentro o id do cliente e preenche os campos da 
    //anamnese desse cliente
    public void pegarDadosAnamneseCliente(int id_cliente) {
        AnamneseDao aDao = new AnamneseDao();
        Anamnese a = new Anamnese();

        a = aDao.consultarAnamnese(id_cliente);
        //chequei se o objeto a esta nulo ou nao, se ele nao estiver nulo entao eu uso ele
        //para preencher os campos
        if (a != null) {

            //checar 1 a 1 pra saber qual eh a informação no banco e
            //auto selecionar o radioB correto
           
            //*******************************************************************************
            if (a.getCirurgia().equals("Não")) {
                cirurgiaNao.setSelected(true);
                txtQualCirurgia.setEnabled(false);
            } else if (a.getCirurgia().equals("Sim")) {
                cirurgiaSim.setSelected(true);

            }

            if (a.getEtilante().equals("Não")) {
                etilanteNao.setSelected(true);
                txtQualEtilante.setEnabled(false);
            } else if (a.getEtilante().equals("Sim")) {
                etilanteSim.setSelected(true);
            }
            if (a.getEsporte().equals("Não")) {
                esporteNao.setSelected(true);
                txtQualEsporte.setEnabled(false);
            } else if (a.getEsporte().equals("Sim")) {
                esporteSim.setSelected(true);
            }
            if (a.getMedicamento().equals("Não")) {
                medicamentoNao.setSelected(true);
                txtQualMedicamento.setEnabled(false);
            } else if (a.getMedicamento().equals("Sim")) {
                medicamentoSim.setSelected(true);
            }

            if (a.getAlergico().equals("Não")) {
                alergicoNao.setSelected(true);
                txtQualAlergia.setEnabled(false);
            } else if (a.getAlergico().equals("Sim")) {
                alergicoSim.setSelected(true);
            }

            if (a.getDiabetes().equals("Sim")) {
                diabetesSim.setSelected(true);
            } else if (a.getDiabetes().equals("Não")) {
                diabetesSim.setSelected(false);
            }
            if (a.getPressaoAlta().equals("Sim")) {
                pressaoAltaSim.setSelected(true);
            } else if (a.getPressaoAlta().equals("Não")) {
                pressaoAltaSim.setSelected(false);
            }
            if (a.getConvulsao().equals("Sim")) {
                convulsaoSim.setSelected(true);
            } else if (a.getConvulsao().equals("Não")) {
                convulsaoSim.setSelected(false);
            }
            if (a.getProblemasCirculatorios().equals("Sim")) {
                problemasCirculatoriosSim.setSelected(true);
            } else if (a.getProblemasCirculatorios().equals("Não")) {
                problemasCirculatoriosSim.setSelected(false);
            }
            if (a.getMarcapassoPino().equals("Sim")) {
                MarcapassoPinoSim.setSelected(true);
            } else if (a.getMarcapassoPino().equals("Não")) {
                MarcapassoPinoSim.setSelected(false);
            }
            if (a.getOutros().equals("Sim")) {
                outrosSim.setSelected(true);
            } else if (a.getOutros().equals("Não")) {
                outrosSim.setSelected(false);
                txtQualPossui.setEnabled(false);
            }

            //********************************************************************************
            txtQueixa.setText(a.getQueixa());
            txtQualCirurgia.setText(a.getQualCirurgia());
            txtQualEtilante.setText(a.getQualEtilante());
            txtQualEsporte.setText(a.getQualEsporte());
            txtQualMedicamento.setText(a.getQualMedicamento());
            txtQualAlergia.setText(a.getQualAlergia());
            txtObservacao2.setText(a.getObservacao2());
            txtQualPossui.setText(a.getQualPossui());
        }

    }
 
           


   //carrega os dados no frame
    public void carregarVistaPlantar(int id_ClienteVp) {

        VistaPlantar vistaplantar = new VistaPlantar();
        VistaPlantarDao vistadao = new VistaPlantarDao();
        vistaplantar = vistadao.consultarVistaPlantar(id_ClienteVp);
           comboPatologia1.setSelectedItem(vistaplantar.getPatologia1());
           comboPatologia2.setSelectedItem(vistaplantar.getPatologia2());
           comboPatologia3.setSelectedItem(vistaplantar.getPatologia3());
           comboPatologia4.setSelectedItem(vistaplantar.getPatologia4());
           comboPatologia5.setSelectedItem(vistaplantar.getPatologia5());
        txtDaFoto.setText(vistaplantar.getTxtFoto1());
        txtDaFoto2.setText(vistaplantar.getTxtFoto2());
        inserirFoto1.setIcon(new ImageIcon(vistaplantar.getTxtFoto1()));
        inserirFoto2.setIcon(new ImageIcon(vistaplantar.getTxtFoto2()));
        ImageIcon ii = new ImageIcon(vistaplantar.getTxtFoto1());
        ImageIcon ii2 = new ImageIcon(vistaplantar.getTxtFoto2());
        Image img = ii.getImage().getScaledInstance(390, 275, Image.SCALE_SMOOTH);
        Image img2 = ii2.getImage().getScaledInstance(390, 275, Image.SCALE_SMOOTH);
        inserirFoto1.setIcon(new ImageIcon(img));
        inserirFoto2.setIcon(new ImageIcon(img2));

    }

public void carregarVistaDorsal(int id_ClienteVd) {

        VistaDorsal vd = new VistaDorsal();
        VistaDorsalDao vistadorsaldao = new VistaDorsalDao();
        vd = vistadorsaldao.consultarVistaDorsal(id_ClienteVd);
           comboPatologiad1.setSelectedItem(vd.getPatologiad1());
           comboPatologiad2.setSelectedItem(vd.getPatologiad2());
           comboPatologiad3.setSelectedItem(vd.getPatologiad3());
           comboPatologiad4.setSelectedItem(vd.getPatologiad4());
           comboPatologiad5.setSelectedItem(vd.getPatologiad5());
        txtDaFotod1.setText(vd.getTxtFotod1());
        txtDaFotod2.setText(vd.getTxtFotod2());
        inserirFotod1.setIcon(new ImageIcon(vd.getTxtFotod1()));
        inserirFotod2.setIcon(new ImageIcon(vd.getTxtFotod2()));
        ImageIcon ii3 = new ImageIcon(vd.getTxtFotod1());
        ImageIcon ii4 = new ImageIcon(vd.getTxtFotod2());
        Image img = ii3.getImage().getScaledInstance(390, 275, Image.SCALE_SMOOTH);
        Image img2 = ii4.getImage().getScaledInstance(390, 275, Image.SCALE_SMOOTH);
        inserirFotod1.setIcon(new ImageIcon(img));
        inserirFotod2.setIcon(new ImageIcon(img2));

    }

//método que carrega o caminho da imagem em um campo de texto e inseri ela no jLabel
    public void getBuscarFoto() {
        JFileChooser foto = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        foto.addChoosableFileFilter(filter);

        int caminho = foto.showOpenDialog(null);

        File file = foto.getSelectedFile();

        if (caminho == foto.APPROVE_OPTION) {
            txtDaFoto.setText(file.getPath());
            ImageIcon ii = new ImageIcon(file.getPath());
            Image img = ii.getImage().getScaledInstance(390, 275, Image.SCALE_SMOOTH);
            inserirFoto1.setIcon(new ImageIcon(img));

        }
    }

    public void getBuscarFoto2() {
        JFileChooser foto2 = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        foto2.addChoosableFileFilter(filter);

        int caminho2 = foto2.showOpenDialog(null);

        File file2 = foto2.getSelectedFile();

        if (caminho2 == foto2.APPROVE_OPTION) {
            txtDaFoto2.setText(file2.getPath());
            ImageIcon ii2 = new ImageIcon(file2.getPath());
            Image img2 = ii2.getImage().getScaledInstance(390, 275, Image.SCALE_SMOOTH);
            inserirFoto2.setIcon(new ImageIcon(img2));

        }

       }
        
  public void getBuscarFoto3() {
        JFileChooser foto3 = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        foto3.addChoosableFileFilter(filter);

        int caminho = foto3.showOpenDialog(null);

        File file = foto3.getSelectedFile();

        if (caminho == foto3.APPROVE_OPTION) {
            txtDaFotod1.setText(file.getPath());
            ImageIcon ii3 = new ImageIcon(file.getPath());
            Image img = ii3.getImage().getScaledInstance(390, 275, Image.SCALE_SMOOTH);
            inserirFotod1.setIcon(new ImageIcon(img));

        }
}
    
 public void getBuscarFoto4() {
        JFileChooser foto4 = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        foto4.addChoosableFileFilter(filter);

        int caminho = foto4.showOpenDialog(null);

        File file = foto4.getSelectedFile();

        if (caminho == foto4.APPROVE_OPTION) {
            txtDaFotod2.setText(file.getPath());
            ImageIcon ii4 = new ImageIcon(file.getPath());
            Image img = ii4.getImage().getScaledInstance(390, 275, Image.SCALE_SMOOTH);
            inserirFotod2.setIcon(new ImageIcon(img));

        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrpCirurgia = new javax.swing.ButtonGroup();
        GrpEtilante = new javax.swing.ButtonGroup();
        GrpEsporte = new javax.swing.ButtonGroup();
        GrpMedicamento = new javax.swing.ButtonGroup();
        GrpAlergico = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jComboBoxUf = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        jLabel25 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtQueixa = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        JlabelCirurgia = new javax.swing.JLabel();
        qualCirurgia = new javax.swing.JLabel();
        txtQualCirurgia = new javax.swing.JTextField();
        cirurgiaSim = new javax.swing.JRadioButton();
        cirurgiaNao = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        JlabelEtilante = new javax.swing.JLabel();
        qualEtilante = new javax.swing.JLabel();
        txtQualEtilante = new javax.swing.JTextField();
        etilanteSim = new javax.swing.JRadioButton();
        etilanteNao = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        JlabelEsporte = new javax.swing.JLabel();
        qualEsporte = new javax.swing.JLabel();
        txtQualEsporte = new javax.swing.JTextField();
        esporteSim = new javax.swing.JRadioButton();
        esporteNao = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        JlabelAlergico = new javax.swing.JLabel();
        qualAlergia = new javax.swing.JLabel();
        txtQualAlergia = new javax.swing.JTextField();
        alergicoSim = new javax.swing.JRadioButton();
        alergicoNao = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        JlabelMedicamento = new javax.swing.JLabel();
        qualMedicamento = new javax.swing.JLabel();
        txtQualMedicamento = new javax.swing.JTextField();
        medicamentoSim = new javax.swing.JRadioButton();
        medicamentoNao = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        diabetesSim = new javax.swing.JCheckBox();
        pressaoAltaSim = new javax.swing.JCheckBox();
        convulsaoSim = new javax.swing.JCheckBox();
        problemasCirculatoriosSim = new javax.swing.JCheckBox();
        MarcapassoPinoSim = new javax.swing.JCheckBox();
        outrosSim = new javax.swing.JCheckBox();
        txtQualPossui = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnEditarAnamnese = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacao2 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        comboPatologia1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboPatologia2 = new javax.swing.JComboBox();
        comboPatologia3 = new javax.swing.JComboBox();
        comboPatologia4 = new javax.swing.JComboBox();
        comboPatologia5 = new javax.swing.JComboBox();
        inserirFoto1 = new javax.swing.JLabel();
        inserirFoto2 = new javax.swing.JLabel();
        txtDaFoto = new javax.swing.JTextField();
        txtDaFoto2 = new javax.swing.JTextField();
        btnBuscarFoto = new javax.swing.JButton();
        btnBuscarFoto2 = new javax.swing.JButton();
        BtnEditarVp = new javax.swing.JButton();
        btnCancelarVp = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        comboPatologiad1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        comboPatologiad2 = new javax.swing.JComboBox();
        comboPatologiad3 = new javax.swing.JComboBox();
        comboPatologiad4 = new javax.swing.JComboBox();
        comboPatologiad5 = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        inserirFotod1 = new javax.swing.JLabel();
        inserirFotod2 = new javax.swing.JLabel();
        salvarPlantar2 = new javax.swing.JButton();
        txtDaFotod1 = new javax.swing.JTextField();
        txtDaFotod2 = new javax.swing.JTextField();
        btnBuscarFotod1 = new javax.swing.JButton();
        btnBuscarFotod2 = new javax.swing.JButton();
        BtnEditarVp1 = new javax.swing.JButton();
        btnCancelarVp1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel14.setText("ID");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel15.setText("Nome");

        jLabel16.setText("CPF");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel17.setText("RG");

        txtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRgActionPerformed(evt);
            }
        });

        jLabel18.setText("Nascimento");

        try {
            txtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel19.setText("CEP");

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCepKeyPressed(evt);
            }
        });

        jLabel20.setText("Endereço");

        jLabel21.setText("Bairro");

        jLabel22.setText("Cidade");

        jLabel23.setText("UF");

        jComboBoxUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", " " }));
        jComboBoxUf.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jComboBoxUfAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jComboBoxUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUfActionPerformed(evt);
            }
        });

        jLabel24.setText("Telefone");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel25.setText("Celular");

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel26.setText("Email");

        jLabel27.setText("Observação");

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        txtObservacao.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(txtObservacao);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sair.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel9.setText("N°");

        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel25)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel26)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel23)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jComboBoxUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(7, 7, 7))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel18)
                                    .addGap(148, 148, 148))
                                .addComponent(jLabel27)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel14))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(7, 7, 7)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(24, 24, 24)
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(94, 94, 94))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCpf)
                    .addComponent(jLabel17)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jComboBoxUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(469, 469, 469))
        );

        jTabbedPane1.addTab("Dados Pessoais", jPanel1);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Anamnese"));

        jLabel1.setText("Queixa Principal");

        txtQueixa.setColumns(20);
        txtQueixa.setRows(5);
        jScrollPane5.setViewportView(txtQueixa);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JlabelCirurgia.setText("Ja fez cirurgia?");

        qualCirurgia.setText("Qual?");

        cirurgiaSim.setText("Sim");

        cirurgiaNao.setText("Não");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlabelCirurgia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cirurgiaSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cirurgiaNao)
                .addGap(18, 18, 18)
                .addComponent(qualCirurgia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQualCirurgia)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlabelCirurgia)
                    .addComponent(qualCirurgia)
                    .addComponent(txtQualCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cirurgiaSim)
                    .addComponent(cirurgiaNao))
                .addGap(23, 23, 23))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JlabelEtilante.setText("Etilante?");

        qualEtilante.setText("Qual?");

        etilanteSim.setText("Sim");

        etilanteNao.setText("Não");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlabelEtilante)
                .addGap(30, 30, 30)
                .addComponent(etilanteSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etilanteNao)
                .addGap(18, 18, 18)
                .addComponent(qualEtilante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtQualEtilante)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlabelEtilante)
                    .addComponent(etilanteSim)
                    .addComponent(etilanteNao)
                    .addComponent(qualEtilante)
                    .addComponent(txtQualEtilante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JlabelEsporte.setText("Pratica Esporte?");

        qualEsporte.setText("Qual?");

        esporteSim.setText("Sim");

        esporteNao.setText("Não");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlabelEsporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(esporteSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(esporteNao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qualEsporte)
                .addGap(18, 18, 18)
                .addComponent(txtQualEsporte)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlabelEsporte)
                    .addComponent(qualEsporte)
                    .addComponent(txtQualEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(esporteSim)
                    .addComponent(esporteNao))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JlabelAlergico.setText("É alergico?");

        qualAlergia.setText("Qual?");

        alergicoSim.setText("Sim");

        alergicoNao.setText("Não");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlabelAlergico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alergicoSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alergicoNao)
                .addGap(24, 24, 24)
                .addComponent(qualAlergia)
                .addGap(18, 18, 18)
                .addComponent(txtQualAlergia)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlabelAlergico)
                    .addComponent(alergicoSim)
                    .addComponent(alergicoNao)
                    .addComponent(qualAlergia)
                    .addComponent(txtQualAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JlabelMedicamento.setText("Toma Medicamento?");

        qualMedicamento.setText("Qual?");

        medicamentoSim.setText("Sim");

        medicamentoNao.setText("Não");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(JlabelMedicamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicamentoSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicamentoNao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(qualMedicamento)
                .addGap(18, 18, 18)
                .addComponent(txtQualMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlabelMedicamento)
                    .addComponent(medicamentoSim)
                    .addComponent(medicamentoNao)
                    .addComponent(qualMedicamento)
                    .addComponent(txtQualMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Possui");

        diabetesSim.setText("Diabetes");

        pressaoAltaSim.setText("Pressão alta");
        pressaoAltaSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressaoAltaSimActionPerformed(evt);
            }
        });

        convulsaoSim.setText("Convulsão");
        convulsaoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convulsaoSimActionPerformed(evt);
            }
        });

        problemasCirculatoriosSim.setText("Problemas circulatórios");
        problemasCirculatoriosSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                problemasCirculatoriosSimActionPerformed(evt);
            }
        });

        MarcapassoPinoSim.setText("Marcapasso ou pino");
        MarcapassoPinoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcapassoPinoSimActionPerformed(evt);
            }
        });

        outrosSim.setText("Outros");
        outrosSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outrosSimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(diabetesSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pressaoAltaSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(convulsaoSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(problemasCirculatoriosSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MarcapassoPinoSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outrosSim)
                        .addGap(103, 103, 103))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(txtQualPossui, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diabetesSim)
                    .addComponent(pressaoAltaSim)
                    .addComponent(convulsaoSim)
                    .addComponent(problemasCirculatoriosSim)
                    .addComponent(MarcapassoPinoSim)
                    .addComponent(jLabel5)
                    .addComponent(outrosSim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQualPossui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel13.setText("Observação");

        btnEditarAnamnese.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar.png"))); // NOI18N
        btnEditarAnamnese.setText("Editar");
        btnEditarAnamnese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAnamneseActionPerformed(evt);
            }
        });

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sair.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        txtObservacao2.setColumns(20);
        txtObservacao2.setRows(5);
        jScrollPane3.setViewportView(txtObservacao2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(520, 520, 520)
                        .addComponent(btnEditarAnamnese, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelar))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarAnamnese, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(773, 773, 773))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Anamnese", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Vista Plantar")));

        comboPatologia1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Ressecamento", "Hiperidrose", "Disidrose", "Bromidrose", "Hiperqueratose", "Micose Plantar", "Micose Interdigital", "Onicocriptose", "Onicofose", "Exostose", "Granulado", "Micose Ungueal", "Psoriase", " ", " " }));
        comboPatologia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPatologia1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Patologia 1");

        jLabel3.setText("Patologia 2");

        jLabel4.setText("Patologia 3");

        jLabel6.setText("Patologia 4");

        jLabel7.setText("Patologia5");

        comboPatologia2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Ressecamento", "Hiperidrose", "Disidrose", "Bromidrose", "Hiperqueratose", "Micose Plantar", "Micose Interdigital", "Onicocriptose", "Onicofose", "Exostose", "Granulado", "Micose Ungueal", "Psoriase" }));

        comboPatologia3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Ressecamento", "Hiperidrose", "Disidrose", "Bromidrose", "Hiperqueratose", "Micose Plantar", "Micose Interdigital", "Onicocriptose", "Onicofose", "Exostose", "Granulado", "Micose Ungueal", "Psoriase" }));

        comboPatologia4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Ressecamento", "Hiperidrose", "Disidrose", "Bromidrose", "Hiperqueratose", "Micose Plantar", "Micose Interdigital", "Onicocriptose", "Onicofose", "Exostose", "Granulado", "Micose Ungueal", "Psoriase" }));

        comboPatologia5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Ressecamento", "Hiperidrose", "Disidrose", "Bromidrose", "Hiperqueratose", "Micose Plantar", "Micose Interdigital", "Onicocriptose", "Onicofose", "Exostose", "Granulado", "Micose Ungueal", "Psoriase" }));

        inserirFoto1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        inserirFoto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inserirFoto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inserirFoto1MouseClicked(evt);
            }
        });

        inserirFoto2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        inserirFoto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inserirFoto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inserirFoto2MouseClicked(evt);
            }
        });

        txtDaFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDaFotoActionPerformed(evt);
            }
        });

        btnBuscarFoto.setText("Arquivo");
        btnBuscarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotoActionPerformed(evt);
            }
        });

        btnBuscarFoto2.setText("Arquivo");
        btnBuscarFoto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFoto2ActionPerformed(evt);
            }
        });

        BtnEditarVp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar.png"))); // NOI18N
        BtnEditarVp.setText("Editar");
        BtnEditarVp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarVpActionPerformed(evt);
            }
        });

        btnCancelarVp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sair.png"))); // NOI18N
        btnCancelarVp.setText("Cancelar");
        btnCancelarVp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboPatologia1, 0, 662, Short.MAX_VALUE)
                            .addComponent(comboPatologia2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboPatologia3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboPatologia4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboPatologia5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDaFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(inserirFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(inserirFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(BtnEditarVp, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarVp, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPatologia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboPatologia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboPatologia3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(comboPatologia4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboPatologia5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inserirFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inserirFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDaFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFoto2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEditarVp, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarVp, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(620, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vista Plantar", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Vista Dorsal"));

        comboPatologiad1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Ressecamento", "Hiperidrose", "Disidrose", "Bromidrose", "Hiperqueratose", "Micose Plantar", "Micose Interdigital", "Onicocriptose", "Onicofose", "Exostose", "Granulado", "Micose Ungueal", "Psoriase", " ", " " }));
        comboPatologiad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPatologiad1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Patologia 1");

        jLabel11.setText("Patologia 2");

        jLabel12.setText("Patologia 3");

        jLabel28.setText("Patologia 4");

        jLabel29.setText("Patologia5");

        comboPatologiad2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Ressecamento", "Hiperidrose", "Disidrose", "Bromidrose", "Hiperqueratose", "Micose Plantar", "Micose Interdigital", "Onicocriptose", "Onicofose", "Exostose", "Granulado", "Micose Ungueal", "Psoriase" }));

        comboPatologiad3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Ressecamento", "Hiperidrose", "Disidrose", "Bromidrose", "Hiperqueratose", "Micose Plantar", "Micose Interdigital", "Onicocriptose", "Onicofose", "Exostose", "Granulado", "Micose Ungueal", "Psoriase" }));

        comboPatologiad4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Ressecamento", "Hiperidrose", "Disidrose", "Bromidrose", "Hiperqueratose", "Micose Plantar", "Micose Interdigital", "Onicocriptose", "Onicofose", "Exostose", "Granulado", "Micose Ungueal", "Psoriase" }));

        comboPatologiad5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Ressecamento", "Hiperidrose", "Disidrose", "Bromidrose", "Hiperqueratose", "Micose Plantar", "Micose Interdigital", "Onicocriptose", "Onicofose", "Exostose", "Granulado", "Micose Ungueal", "Psoriase" }));

        inserirFotod1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        inserirFotod1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inserirFotod1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inserirFotod1MouseClicked(evt);
            }
        });

        inserirFotod2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        inserirFotod2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inserirFotod2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inserirFotod2MouseClicked(evt);
            }
        });

        salvarPlantar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        salvarPlantar2.setText("Salvar");
        salvarPlantar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarPlantar2ActionPerformed(evt);
            }
        });

        btnBuscarFotod1.setText("Arquivo");
        btnBuscarFotod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotod1ActionPerformed(evt);
            }
        });

        btnBuscarFotod2.setText("Arquivo");
        btnBuscarFotod2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotod2ActionPerformed(evt);
            }
        });

        BtnEditarVp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar.png"))); // NOI18N
        BtnEditarVp1.setText("Editar");
        BtnEditarVp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarVp1ActionPerformed(evt);
            }
        });

        btnCancelarVp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sair.png"))); // NOI18N
        btnCancelarVp1.setText("Cancelar");
        btnCancelarVp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVp1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inserirFotod2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboPatologiad4, 0, 662, Short.MAX_VALUE)
                            .addComponent(comboPatologiad5, 0, 662, Short.MAX_VALUE)
                            .addComponent(comboPatologiad2, 0, 662, Short.MAX_VALUE)
                            .addComponent(comboPatologiad3, 0, 662, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(salvarPlantar2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnEditarVp1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelarVp1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(txtDaFotod2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnBuscarFotod2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(txtDaFotod1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnBuscarFotod1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE))))
                            .addComponent(comboPatologiad1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(inserirFotod1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 62, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPatologiad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboPatologiad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboPatologiad3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(comboPatologiad4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(comboPatologiad5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inserirFotod1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDaFotod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFotod1))
                .addGap(14, 14, 14)
                .addComponent(inserirFotod2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDaFotod2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFotod2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarVp1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEditarVp1)
                    .addComponent(salvarPlantar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(78, 78, 78)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
        );

        jTabbedPane1.addTab(" Vista Dorsal", jPanel4);

        jScrollPane1.setViewportView(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgActionPerformed

    private void txtCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyPressed
        //Programacao do keypress
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Clientes obj = new Clientes();
            ClientesDao dao = new ClientesDao();
            obj = dao.buscaCep(txtCep.getText());

            txtEndereco.setText(obj.getEndereco());
            txtBairro.setText(obj.getBairro());
            txtCidade.setText(obj.getCidade());
            jComboBoxUf.setSelectedItem(obj.getUf());

        }
    }//GEN-LAST:event_txtCepKeyPressed

    private void jComboBoxUfAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jComboBoxUfAncestorAdded

    }//GEN-LAST:event_jComboBoxUfAncestorAdded

    private void jComboBoxUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUfActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //botao editar

        Clientes clientes = new Clientes();
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String nascimento = formatador.format(data);

        clientes.setNome(txtNome.getText());
        clientes.setCpf(txtCpf.getText());
        clientes.setRg(txtRg.getText());
        clientes.setNascimento(txtNascimento.getText());
        clientes.setCep(txtCep.getText());
        clientes.setEndereco(txtEndereco.getText());
        clientes.setNumero(Integer.parseInt(txtNumero.getText()));
        clientes.setUf(jComboBoxUf.getSelectedItem().toString());
        clientes.setBairro(txtBairro.getText());
        clientes.setCidade(txtCidade.getText());
        clientes.setTelefone(txtTelefone.getText());
        clientes.setCelular(txtCelular.getText());
        clientes.setEmail(txtEmail.getText());
        clientes.setObservacao(txtObservacao.getText());
        clientes.setId(Integer.parseInt(txtId.getText()));
        //2passo - Criar um objeto do tipo ClienteDao
        try {

            ClientesDao clientesdao = new ClientesDao();
            clientesdao.alterarCliente(clientes);
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void pressaoAltaSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pressaoAltaSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pressaoAltaSimActionPerformed

    private void convulsaoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convulsaoSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_convulsaoSimActionPerformed

    private void problemasCirculatoriosSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_problemasCirculatoriosSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_problemasCirculatoriosSimActionPerformed

    private void MarcapassoPinoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcapassoPinoSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarcapassoPinoSimActionPerformed

    private void outrosSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outrosSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outrosSimActionPerformed

    private void btnEditarAnamneseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAnamneseActionPerformed
        editarAnamnese(Integer.parseInt(txtId.getText()));
    }//GEN-LAST:event_btnEditarAnamneseActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void comboPatologia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPatologia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPatologia1ActionPerformed

    private void inserirFoto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inserirFoto1MouseClicked

    


    }//GEN-LAST:event_inserirFoto1MouseClicked

    private void inserirFoto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inserirFoto2MouseClicked

    }//GEN-LAST:event_inserirFoto2MouseClicked

    private void btnBuscarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotoActionPerformed
     
        try {
            this.getBuscarFoto();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBuscarFotoActionPerformed

    private void btnBuscarFoto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFoto2ActionPerformed
        try {
            this.getBuscarFoto2();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnBuscarFoto2ActionPerformed

    private void btnCancelarVpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVpActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarVpActionPerformed

    private void BtnEditarVpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarVpActionPerformed
        alterarVistaPlantar(Integer.parseInt(txtId.getText()));
    }//GEN-LAST:event_BtnEditarVpActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void comboPatologiad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPatologiad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPatologiad1ActionPerformed

    private void inserirFotod1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inserirFotod1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_inserirFotod1MouseClicked

    private void inserirFotod2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inserirFotod2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_inserirFotod2MouseClicked

    private void salvarPlantar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarPlantar2ActionPerformed
       Clientes clientes = new Clientes();
        Anamnese anamnese = new Anamnese();
       

        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String nascimento = formatador.format(data);

        clientes.setNome(txtNome.getText());
        clientes.setCpf(txtCpf.getText());
        clientes.setRg(txtRg.getText());
        clientes.setNascimento(txtNascimento.getText());
        clientes.setCep(txtCep.getText());
        clientes.setEndereco(txtEndereco.getText());
        clientes.setNumero(Integer.parseInt(txtNumero.getText()));
        clientes.setUf(jComboBoxUf.getSelectedItem().toString());
        clientes.setBairro(txtBairro.getText());
        clientes.setCidade(txtCidade.getText());
        clientes.setTelefone(txtTelefone.getText());
        clientes.setCelular(txtCelular.getText());
        clientes.setEmail(txtEmail.getText());
        clientes.setObservacao(txtObservacao.getText());
        
        //2passo - Criar um objeto do tipo ClienteDao
        try {
            ClientesDao clientesdao = new ClientesDao();

            clientesdao.cadastrarCliente(clientes);
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado");
        } catch (Exception e) {
             e.printStackTrace();
          JOptionPane.showMessageDialog(null, "Erro ao Cadastrar" + e);
        }
  
            
        salvarAnamnese(Integer.parseInt(txtId.getText()));
        salvarVistaPlantar(Integer.parseInt(txtId.getText()));
        salvarVistaDorsal(Integer.parseInt(txtId.getText()));
    }//GEN-LAST:event_salvarPlantar2ActionPerformed

    private void btnBuscarFotod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotod1ActionPerformed
        try {
            getBuscarFoto3();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBuscarFotod1ActionPerformed

    private void btnBuscarFotod2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotod2ActionPerformed
        try {
            getBuscarFoto4();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBuscarFotod2ActionPerformed

    private void BtnEditarVp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarVp1ActionPerformed
        alterarVistaDorsal(Integer.parseInt(txtId.getText()));
    }//GEN-LAST:event_BtnEditarVp1ActionPerformed

    private void btnCancelarVp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVp1ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarVp1ActionPerformed

    private void txtDaFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDaFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDaFotoActionPerformed

   
    //parametro de entrada do metodo é um inteiro que será o id desse cliente que esta sendo cadastrado
    public void salvarAnamnese(Integer id_cliente) {
        Anamnese anamnese = new Anamnese();
        AnamneseDao anamnesedao = new AnamneseDao();

        anamnese.setQueixa(txtQueixa.getText());
        anamnese.setQualCirurgia(txtQualCirurgia.getText());
        anamnese.setQualEtilante(txtQualEtilante.getText());
        anamnese.setQualEsporte(txtQualEsporte.getText());
        anamnese.setQualMedicamento(txtQualMedicamento.getText());
        anamnese.setQualAlergia(txtQualAlergia.getText());
        String cirurgia = cirurgiaSim.isSelected() ? "Sim" : "Não";
        String etilante = etilanteSim.isSelected() ? "Sim" : "Não";
        String esporte = esporteSim.isSelected() ? "Sim" : "Não";
        String medicamento = medicamentoSim.isSelected() ? "Sim" : "Não";
        String alergico = alergicoSim.isSelected() ? "Sim" : "Não";
        String diabetes = diabetesSim.isSelected() ? "Sim" : "Não";
        String pressoaAlta = pressaoAltaSim.isSelected() ? "Sim" : "Não";
        String convulsao = convulsaoSim.isSelected() ? "Sim" : "Não";
        String problemasCirculatorios = problemasCirculatoriosSim.isSelected() ? "Sim" : "Não";
        String marcapassoPino = MarcapassoPinoSim.isSelected() ? "Sim" : "Não";
        String outros = outrosSim.isSelected() ? "Sim" : "Não";
        anamnese.setCirurgia(cirurgia);
        anamnese.setEtilante(etilante);
        anamnese.setEsporte(esporte);
        anamnese.setMedicamento(medicamento);
        anamnese.setAlergico(alergico);
        anamnese.setObservacao2(txtObservacao2.getText());
        anamnese.setDiabetes(diabetes);
        anamnese.setPressaoAlta(pressoaAlta);
        anamnese.setConvulsao(convulsao);
        anamnese.setProblemasCirculatorios(problemasCirculatorios);
        anamnese.setMarcapassoPino(marcapassoPino);
        anamnese.setOutros(outros);
        anamnese.setQualPossui(txtQualPossui.getText());
         anamnese.setIdCliente(id_cliente);
        try {

            anamnesedao.cadastrarAnamnese(anamnese);
        

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar " + e);
        }
    }

    public void editarAnamnese(Integer id_cliente) {
        Anamnese anamnese = new Anamnese();
        AnamneseDao anamnesedao = new AnamneseDao();

        anamnese.setQueixa(txtQueixa.getText());
        anamnese.setQualCirurgia(txtQualCirurgia.getText());
        anamnese.setQualEtilante(txtQualEtilante.getText());
        anamnese.setQualEsporte(txtQualEsporte.getText());
        anamnese.setQualMedicamento(txtQualMedicamento.getText());
        anamnese.setQualAlergia(txtQualAlergia.getText());
        String cirurgia = cirurgiaSim.isSelected() ? "Sim" : "Não";
        String etilante = etilanteSim.isSelected() ? "Sim" : "Não";
        String esporte = esporteSim.isSelected() ? "Sim" : "Não";
        String medicamento = medicamentoSim.isSelected() ? "Sim" : "Não";
        String alergico = alergicoSim.isSelected() ? "Sim" : "Não";
        String diabetes = diabetesSim.isSelected() ? "Sim" : "Não";
        String pressoaAlta = pressaoAltaSim.isSelected() ? "Sim" : "Não";
        String convulsao = convulsaoSim.isSelected() ? "Sim" : "Não";
        String problemasCirculatorios = problemasCirculatoriosSim.isSelected() ? "Sim" : "Não";
        String marcapassoPino = MarcapassoPinoSim.isSelected() ? "Sim" : "Não";
        String outros = outrosSim.isSelected() ? "Sim" : "Não";
        anamnese.setCirurgia(cirurgia);
        anamnese.setEtilante(etilante);
        anamnese.setEsporte(esporte);
        anamnese.setMedicamento(medicamento);
        anamnese.setAlergico(alergico);
        anamnese.setIdCliente(id_cliente);
        anamnese.setObservacao2(txtObservacao2.getText());
        anamnese.setDiabetes(diabetes);
        anamnese.setPressaoAlta(pressoaAlta);
        anamnese.setConvulsao(convulsao);
        anamnese.setProblemasCirculatorios(problemasCirculatorios);
        anamnese.setMarcapassoPino(marcapassoPino);
        anamnese.setOutros(outros);
        anamnese.setQualPossui(txtQualPossui.getText());

        try {

            anamnesedao.editarAnamnese(anamnese);
            JOptionPane.showMessageDialog(null, "Informações Editadas com Sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Editar " + e);
        }
    }

    public void salvarVistaPlantar(Integer id_ClienteVp) {
        VistaPlantar vistaplantar = new VistaPlantar();
        VistaPlantarDao vistaplantardao = new VistaPlantarDao();

        vistaplantar.setPatologia1(comboPatologia1.getSelectedItem().toString());
        vistaplantar.setPatologia2(comboPatologia2.getSelectedItem().toString());
        vistaplantar.setPatologia3(comboPatologia3.getSelectedItem().toString());
        vistaplantar.setPatologia4(comboPatologia4.getSelectedItem().toString());
        vistaplantar.setPatologia5(comboPatologia5.getSelectedItem().toString());
        //salva caminho da foto no banco de dados
        vistaplantar.setTxtFoto1(txtDaFoto.getText());
        vistaplantar.setTxtFoto2(txtDaFoto2.getText());

        vistaplantar.setIdClienteVp(id_ClienteVp);

        try {

            vistaplantardao.Inserir(vistaplantar);

            

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar!");
        }

    }
 public void alterarVistaPlantar(Integer id_ClienteVp) {
        VistaPlantar vistaplantar = new VistaPlantar();
        VistaPlantarDao vistaplantardao = new VistaPlantarDao();
        vistaplantar.setPatologia1(comboPatologia1.getSelectedItem().toString());
        vistaplantar.setPatologia2(comboPatologia2.getSelectedItem().toString());
        vistaplantar.setPatologia3(comboPatologia3.getSelectedItem().toString());
        vistaplantar.setPatologia4(comboPatologia4.getSelectedItem().toString());
        vistaplantar.setPatologia5(comboPatologia5.getSelectedItem().toString());

   
        vistaplantar.setTxtFoto1(txtDaFoto.getText());
        vistaplantar.setTxtFoto2(txtDaFoto2.getText());

        vistaplantar.setIdClienteVp(id_ClienteVp);

        try {

            vistaplantardao.editarVistaPlantar(vistaplantar);

            JOptionPane.showMessageDialog(null, "Informações alteradas com Sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar!");
        }
}

public void salvarVistaDorsal(Integer id_ClienteVd) {
        VistaDorsal vistadorsal = new VistaDorsal();
        VistaDorsalDao vistadorsaldao = new VistaDorsalDao();

        vistadorsal.setPatologiad1(comboPatologiad1.getSelectedItem().toString());
        vistadorsal.setPatologiad2(comboPatologiad2.getSelectedItem().toString());
        vistadorsal.setPatologiad3(comboPatologiad3.getSelectedItem().toString());
        vistadorsal.setPatologiad4(comboPatologiad4.getSelectedItem().toString());
        vistadorsal.setPatologiad5(comboPatologiad5.getSelectedItem().toString());
        //salva caminho da foto no banco de dados
        vistadorsal.setTxtFotod1(txtDaFotod1.getText());
        vistadorsal.setTxtFotod2(txtDaFotod2.getText());

        vistadorsal.setIdClienteVd(id_ClienteVd);

        try {

            vistadorsaldao.InserirDorsal(vistadorsal);

            JOptionPane.showMessageDialog(null, "Informações cadastradas com Sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar!");
        }

    }
public void alterarVistaDorsal(Integer id_ClienteVd) {
        VistaDorsal vistadorsal = new VistaDorsal();
        VistaDorsalDao vistadorsaldao = new VistaDorsalDao();
        vistadorsal.setPatologiad1(comboPatologiad1.getSelectedItem().toString());
        vistadorsal.setPatologiad2(comboPatologiad2.getSelectedItem().toString());
        vistadorsal.setPatologiad3(comboPatologiad3.getSelectedItem().toString());
        vistadorsal.setPatologiad4(comboPatologiad4.getSelectedItem().toString());
        vistadorsal.setPatologiad5(comboPatologiad5.getSelectedItem().toString());

  
        vistadorsal.setTxtFotod1(txtDaFotod1.getText());
        vistadorsal.setTxtFotod2(txtDaFotod2.getText());

        vistadorsal.setIdClienteVd(id_ClienteVd);

        try {

            vistadorsaldao.editarVistaDorsal(vistadorsal);

            JOptionPane.showMessageDialog(null, "Informações alteradas com Sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar!");
        }
}


    
   

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCliente(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditarVp;
    private javax.swing.JButton BtnEditarVp1;
    private javax.swing.ButtonGroup GrpAlergico;
    private javax.swing.ButtonGroup GrpCirurgia;
    private javax.swing.ButtonGroup GrpEsporte;
    private javax.swing.ButtonGroup GrpEtilante;
    private javax.swing.ButtonGroup GrpMedicamento;
    private javax.swing.JLabel JlabelAlergico;
    private javax.swing.JLabel JlabelCirurgia;
    private javax.swing.JLabel JlabelEsporte;
    private javax.swing.JLabel JlabelEtilante;
    private javax.swing.JLabel JlabelMedicamento;
    private javax.swing.JCheckBox MarcapassoPinoSim;
    private javax.swing.JRadioButton alergicoNao;
    private javax.swing.JRadioButton alergicoSim;
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnBuscarFoto2;
    private javax.swing.JButton btnBuscarFotod1;
    private javax.swing.JButton btnBuscarFotod2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarVp;
    private javax.swing.JButton btnCancelarVp1;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditarAnamnese;
    private javax.swing.JButton cancelar;
    private javax.swing.JRadioButton cirurgiaNao;
    private javax.swing.JRadioButton cirurgiaSim;
    public javax.swing.JComboBox comboPatologia1;
    public javax.swing.JComboBox comboPatologia2;
    public javax.swing.JComboBox comboPatologia3;
    public javax.swing.JComboBox comboPatologia4;
    public javax.swing.JComboBox comboPatologia5;
    public javax.swing.JComboBox comboPatologiad1;
    public javax.swing.JComboBox comboPatologiad2;
    public javax.swing.JComboBox comboPatologiad3;
    public javax.swing.JComboBox comboPatologiad4;
    public javax.swing.JComboBox comboPatologiad5;
    private javax.swing.JCheckBox convulsaoSim;
    private javax.swing.JCheckBox diabetesSim;
    private javax.swing.JRadioButton esporteNao;
    private javax.swing.JRadioButton esporteSim;
    private javax.swing.JRadioButton etilanteNao;
    private javax.swing.JRadioButton etilanteSim;
    public javax.swing.JLabel inserirFoto1;
    private javax.swing.JLabel inserirFoto2;
    public javax.swing.JLabel inserirFotod1;
    private javax.swing.JLabel inserirFotod2;
    public javax.swing.JComboBox jComboBoxUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton medicamentoNao;
    private javax.swing.JRadioButton medicamentoSim;
    private javax.swing.JCheckBox outrosSim;
    private javax.swing.JCheckBox pressaoAltaSim;
    private javax.swing.JCheckBox problemasCirculatoriosSim;
    private javax.swing.JLabel qualAlergia;
    private javax.swing.JLabel qualCirurgia;
    private javax.swing.JLabel qualEsporte;
    private javax.swing.JLabel qualEtilante;
    private javax.swing.JLabel qualMedicamento;
    private javax.swing.JButton salvarPlantar2;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtDaFoto;
    private javax.swing.JTextField txtDaFoto2;
    private javax.swing.JTextField txtDaFotod1;
    private javax.swing.JTextField txtDaFotod2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    static javax.swing.JTextField txtId;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextArea txtObservacao2;
    private javax.swing.JTextField txtQualAlergia;
    private javax.swing.JTextField txtQualCirurgia;
    private javax.swing.JTextField txtQualEsporte;
    private javax.swing.JTextField txtQualEtilante;
    private javax.swing.JTextField txtQualMedicamento;
    private javax.swing.JTextField txtQualPossui;
    private javax.swing.JTextArea txtQueixa;
    private javax.swing.JTextField txtRg;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

}
