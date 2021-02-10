Imports System.Data.OleDb
Public Class login

    Dim conn As New OleDbConnection
    Dim ds As New DataSet
    Dim cmd As New OleDbCommand
    Dim da As New OleDbDataAdapter

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim sql As String = ""
        Dim isfind As Boolean = False
        sql = " select * from Table2 where name='" & TextBox1.Text & "'and  pwd = '" & TextBox2.Text & "'"
        da = New OleDbDataAdapter(sql, conn)
        da.Fill(ds, "Table2")
        If ds.Tables("Table2").Rows.Count <> 0 Then
            isfind = True
            Dim frm As New conData
            frm.Show()
            Me.Hide()
        Else
            isfind =
                MessageBox.Show(" ປ້​ອນ​ຂໍ້​ມູນ​ຜິດ")
        End If
    End Sub

    Private Sub login_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        conn = New OleDbConnection(Module1.strcom)

    End Sub

    Private Sub Label3_Click(sender As Object, e As EventArgs) Handles Label3.Click

    End Sub
End Class