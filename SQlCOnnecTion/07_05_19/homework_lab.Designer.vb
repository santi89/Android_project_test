<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class homework_lab
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.GroupBox1 = New System.Windows.Forms.GroupBox()
        Me.txtptotal = New System.Windows.Forms.TextBox()
        Me.txtpqty = New System.Windows.Forms.TextBox()
        Me.txtpcost = New System.Windows.Forms.TextBox()
        Me.txtpname = New System.Windows.Forms.TextBox()
        Me.pQty = New System.Windows.Forms.Label()
        Me.ptotal = New System.Windows.Forms.Label()
        Me.pcost = New System.Windows.Forms.Label()
        Me.pname = New System.Windows.Forms.Label()
        Me.Button1 = New System.Windows.Forms.Button()
        Me.txtAlltatol = New System.Windows.Forms.TextBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.ListView1 = New System.Windows.Forms.ListView()
        Me.ColumnHeader1 = CType(New System.Windows.Forms.ColumnHeader(), System.Windows.Forms.ColumnHeader)
        Me.ColumnHeader2 = CType(New System.Windows.Forms.ColumnHeader(), System.Windows.Forms.ColumnHeader)
        Me.ColumnHeader3 = CType(New System.Windows.Forms.ColumnHeader(), System.Windows.Forms.ColumnHeader)
        Me.ColumnHeader4 = CType(New System.Windows.Forms.ColumnHeader(), System.Windows.Forms.ColumnHeader)
        Me.GroupBox1.SuspendLayout()
        Me.SuspendLayout()
        '
        'GroupBox1
        '
        Me.GroupBox1.Controls.Add(Me.txtptotal)
        Me.GroupBox1.Controls.Add(Me.txtpqty)
        Me.GroupBox1.Controls.Add(Me.txtpcost)
        Me.GroupBox1.Controls.Add(Me.txtpname)
        Me.GroupBox1.Controls.Add(Me.pQty)
        Me.GroupBox1.Controls.Add(Me.ptotal)
        Me.GroupBox1.Controls.Add(Me.pcost)
        Me.GroupBox1.Controls.Add(Me.pname)
        Me.GroupBox1.Font = New System.Drawing.Font("Saysettha OT", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.GroupBox1.Location = New System.Drawing.Point(12, 63)
        Me.GroupBox1.Name = "GroupBox1"
        Me.GroupBox1.Size = New System.Drawing.Size(543, 162)
        Me.GroupBox1.TabIndex = 0
        Me.GroupBox1.TabStop = False
        Me.GroupBox1.Text = "ລາຍ​ການ​ສິນ​ຄ້າ"
        '
        'txtptotal
        '
        Me.txtptotal.Enabled = False
        Me.txtptotal.Location = New System.Drawing.Point(385, 100)
        Me.txtptotal.Name = "txtptotal"
        Me.txtptotal.Size = New System.Drawing.Size(151, 30)
        Me.txtptotal.TabIndex = 7
        '
        'txtpqty
        '
        Me.txtpqty.Location = New System.Drawing.Point(100, 100)
        Me.txtpqty.Name = "txtpqty"
        Me.txtpqty.Size = New System.Drawing.Size(151, 30)
        Me.txtpqty.TabIndex = 6
        '
        'txtpcost
        '
        Me.txtpcost.Location = New System.Drawing.Point(386, 42)
        Me.txtpcost.Name = "txtpcost"
        Me.txtpcost.Size = New System.Drawing.Size(151, 30)
        Me.txtpcost.TabIndex = 5
        '
        'txtpname
        '
        Me.txtpname.Location = New System.Drawing.Point(100, 42)
        Me.txtpname.Name = "txtpname"
        Me.txtpname.Size = New System.Drawing.Size(151, 30)
        Me.txtpname.TabIndex = 4
        '
        'pQty
        '
        Me.pQty.AutoSize = True
        Me.pQty.Location = New System.Drawing.Point(17, 103)
        Me.pQty.Name = "pQty"
        Me.pQty.Size = New System.Drawing.Size(54, 24)
        Me.pQty.TabIndex = 3
        Me.pQty.Text = "​ຈຳ​ນວນ"
        '
        'ptotal
        '
        Me.ptotal.AutoSize = True
        Me.ptotal.Location = New System.Drawing.Point(322, 103)
        Me.ptotal.Name = "ptotal"
        Me.ptotal.Size = New System.Drawing.Size(37, 24)
        Me.ptotal.TabIndex = 2
        Me.ptotal.Text = "​ລ​ວມ"
        '
        'pcost
        '
        Me.pcost.AutoSize = True
        Me.pcost.Location = New System.Drawing.Point(323, 42)
        Me.pcost.Name = "pcost"
        Me.pcost.Size = New System.Drawing.Size(45, 24)
        Me.pcost.TabIndex = 1
        Me.pcost.Text = "​ລາ​ຄາ"
        '
        'pname
        '
        Me.pname.AutoSize = True
        Me.pname.Location = New System.Drawing.Point(17, 42)
        Me.pname.Name = "pname"
        Me.pname.Size = New System.Drawing.Size(55, 24)
        Me.pname.TabIndex = 0
        Me.pname.Text = "ຊື່​ສິນ​ຄ້າ"
        '
        'Button1
        '
        Me.Button1.Font = New System.Drawing.Font("Saysettha OT", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Button1.Location = New System.Drawing.Point(21, 231)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(527, 49)
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "ເພີ່ມ​ສິນ​ຄ້າ"
        Me.Button1.UseVisualStyleBackColor = True
        '
        'txtAlltatol
        '
        Me.txtAlltatol.Enabled = False
        Me.txtAlltatol.Font = New System.Drawing.Font("Saysettha OT", 11.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtAlltatol.Location = New System.Drawing.Point(386, 498)
        Me.txtAlltatol.Name = "txtAlltatol"
        Me.txtAlltatol.Size = New System.Drawing.Size(151, 34)
        Me.txtAlltatol.TabIndex = 9
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Saysettha OT", 11.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(270, 505)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(110, 27)
        Me.Label1.TabIndex = 8
        Me.Label1.Text = "ເງິນ​ທີ​ຕ້ອງ​ຈ່າຍ"
        '
        'ListView1
        '
        Me.ListView1.Columns.AddRange(New System.Windows.Forms.ColumnHeader() {Me.ColumnHeader1, Me.ColumnHeader2, Me.ColumnHeader3, Me.ColumnHeader4})
        Me.ListView1.Font = New System.Drawing.Font("Saysettha OT", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.ListView1.Location = New System.Drawing.Point(49, 286)
        Me.ListView1.Name = "ListView1"
        Me.ListView1.Size = New System.Drawing.Size(465, 199)
        Me.ListView1.TabIndex = 10
        Me.ListView1.UseCompatibleStateImageBehavior = False
        Me.ListView1.View = System.Windows.Forms.View.Details
        '
        'ColumnHeader1
        '
        Me.ColumnHeader1.Text = "ຊື່"
        Me.ColumnHeader1.Width = 106
        '
        'ColumnHeader2
        '
        Me.ColumnHeader2.Text = "​ລາ​ຄາ"
        Me.ColumnHeader2.Width = 137
        '
        'ColumnHeader3
        '
        Me.ColumnHeader3.Text = "​ຈຳ​ນວນ"
        Me.ColumnHeader3.Width = 90
        '
        'ColumnHeader4
        '
        Me.ColumnHeader4.Text = "​ລວມ"
        Me.ColumnHeader4.Width = 127
        '
        'homework_lab
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(597, 583)
        Me.Controls.Add(Me.ListView1)
        Me.Controls.Add(Me.txtAlltatol)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.GroupBox1)
        Me.Name = "homework_lab"
        Me.Text = "homework_lab"
        Me.GroupBox1.ResumeLayout(False)
        Me.GroupBox1.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents GroupBox1 As System.Windows.Forms.GroupBox
    Friend WithEvents txtptotal As System.Windows.Forms.TextBox
    Friend WithEvents txtpqty As System.Windows.Forms.TextBox
    Friend WithEvents txtpcost As System.Windows.Forms.TextBox
    Friend WithEvents txtpname As System.Windows.Forms.TextBox
    Friend WithEvents pQty As System.Windows.Forms.Label
    Friend WithEvents ptotal As System.Windows.Forms.Label
    Friend WithEvents pcost As System.Windows.Forms.Label
    Friend WithEvents pname As System.Windows.Forms.Label
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents txtAlltatol As System.Windows.Forms.TextBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents ListView1 As System.Windows.Forms.ListView
    Friend WithEvents ColumnHeader1 As System.Windows.Forms.ColumnHeader
    Friend WithEvents ColumnHeader2 As System.Windows.Forms.ColumnHeader
    Friend WithEvents ColumnHeader3 As System.Windows.Forms.ColumnHeader
    Friend WithEvents ColumnHeader4 As System.Windows.Forms.ColumnHeader
End Class
