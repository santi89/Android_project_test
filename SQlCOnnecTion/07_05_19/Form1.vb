Imports System.Data.OleDb

Public Class Form1
    Dim conn As New OleDbConnection
    Dim cmd As New OleDbCommand
    Dim da As New OleDbDataAdapter
    Dim ds As New DataSet
    Dim strcon As String = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=C:\Users\Advice-msi\OneDrive\เอกสาร\fuck.accdb"

    Private Sub DataGridView1_CellContentClick(sender As Object, e As DataGridViewCellEventArgs) Handles DataGridView1.CellContentClick

    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        DataGridView1.ColumnHeadersDefaultCellStyle.ForeColor = Color.Green
        DataGridView1.ColumnHeadersDefaultCellStyle.Alignment = DataGridViewContentAlignment.TopCenter
        DataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill
        DataGridView1.EnableHeadersVisualStyles = False


    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim frm As New addData
        frm.Show()

    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        'With conn
        'If .State = ConnectionState.Open Then .Close()
        '.ConnectionString = strcon
        '.Open()
        'MsgBox("COMPLETE")
        'End With
        conn = New OleDbConnection(strcon)
        conn.Open()
        MsgBox("COMPLETE")
        da = New OleDbDataAdapter("select*from Table1", conn)
        da.Fill(ds, "s")
        DataGridView2.DataSource = ds.Tables(0)
        DataGridView2.Refresh()
        With DataGridView2
            .Columns(0).HeaderText = "ຊື່"
            .Columns(1).HeaderText = "ນາມສະກຸນ"

        End With
        'DataGridView2.Columns(0).Width = 50
        'DataGridView2.Columns(1).Width = 70
        DataGridView2.Columns(0).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
        DataGridView2.Columns(1).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
    End Sub
End Class
