
Imports System.Data.OleDb

Public Class connect
    Dim conn As New OleDbConnection
    Dim da As New OleDbDataAdapter
    Dim ds As New DataSet
    Dim strcon As String = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=vb_form.accdb"
    Private Sub btconnect_Click(sender As Object, e As EventArgs) Handles btconnect.Click
        conn = New OleDbConnection(strcon)
        conn.Open()
        MsgBox("ຕິດ​ຕໍ້​ຖານ​ຂໍ້​ມູນ​ສຳ​ເລັດ")
        da = New OleDbDataAdapter("Select * from Table1", conn)
        da.Fill(ds, "Table1")
        DataGridView1.DataSource = ds.Tables("Table1")

    End Sub

    Private Sub connect_Load(sender As Object, e As EventArgs) Handles MyBase.Load

    End Sub
End Class