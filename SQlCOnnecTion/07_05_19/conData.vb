Imports System.Data.OleDb
Public Class conData
    Dim conn As New OleDbConnection
    Dim da As New OleDbDataAdapter
    Dim ds As New DataSet
    Dim cmd As OleDbCommand

    Private Sub conData_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        'Bsave.Enabled = False
        'bedit.Enabled = False
        'bdelete.Enabled = False
        'TextBox1.Enabled = False
        'TextBox2.Enabled = False
        'MaskedTextBox1.Enabled = False
        'TextBox3.Enabled = False
        'TextBox4.Enabled = False
        conn = New OleDbConnection(Module1.strcom)
        conn.Open()
        showdata()
        DataGridView1.Columns(0).HeaderText = "id"
        DataGridView1.Columns(1).HeaderText = "name"
        DataGridView1.Columns(2).HeaderText = "surname"
        DataGridView1.Columns(3).HeaderText = "adress"
        DataGridView1.Columns(4).HeaderText = "tel"
        DataGridView1.Columns(0).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill

        With DataGridView1

        End With

    End Sub
    Sub showdata()
        ds.Clear()
        da = New OleDbDataAdapter("select* from Table1", conn)
        da.Fill(ds, "Table1")
        DataGridView1.DataSource = ds.Tables(0)
        DataGridView1.Refresh()

    End Sub

    Private Sub Bsave_Click(sender As Object, e As EventArgs) Handles Bsave.Click
        Dim add As String = ""
        add = "insert into Table1(Name,Surname,address,tel) values('" & TextBox1.Text & "','" & TextBox2.Text & "','" & TextBox3.Text & "','" & MaskedTextBox1.Text & "')"
        cmd = New OleDbCommand(add, conn)
        cmd.ExecuteNonQuery()
        MessageBox.Show("Insert Complete")

        showdata()


    End Sub

    Private Sub bedit_Click(sender As Object, e As EventArgs) Handles bedit.Click
        Dim ed As String = ""
        ed = "update Table1 set Name = '" & TextBox1.Text & "', Surname='" & TextBox2.Text & "', address='" & TextBox3.Text & "', tel = '" & MaskedTextBox1.Text & "' where id=" & Label6.Text & ""
        cmd = New OleDbCommand(ed, conn)
        cmd.ExecuteNonQuery()
        MessageBox.Show("Edit Complete")
        showdata()

    End Sub

    Private Sub bdelete_Click(sender As Object, e As EventArgs) Handles bdelete.Click
        Dim del As String = ""
        del = "delete from Table1 where Name='" & TextBox1.Text & "'"
        cmd = New OleDbCommand(del, conn)
        cmd.ExecuteNonQuery()
        MessageBox.Show("Delete Complete")
        showdata()

    End Sub

    Private Sub DataGridView1_CellClick(sender As Object, e As DataGridViewCellEventArgs) Handles DataGridView1.CellClick
        Label6.Text = DataGridView1.Rows(DataGridView1.CurrentRow.Index).Cells(0).Value.ToString
        TextBox1.Text = DataGridView1.Rows(DataGridView1.CurrentRow.Index).Cells(1).Value.ToString
        TextBox2.Text = DataGridView1.Rows(DataGridView1.CurrentRow.Index).Cells(2).Value.ToString
        TextBox3.Text = DataGridView1.Rows(DataGridView1.CurrentRow.Index).Cells(3).Value.ToString
        MaskedTextBox1.Text = DataGridView1.Rows(DataGridView1.CurrentRow.Index).Cells(4).Value.ToString
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        'Bsave.Enabled = True
        'bedit.Enabled = False
        'bdelete.Enabled = False
        'TextBox1.Enabled = False
        'TextBox2.Enabled = False
        'MaskedTextBox1.Enabled = False
        'TextBox3.Enabled = False
        'TextBox4.Enabled = False

    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        Dim sql As String = ""
        If ComboBox1.SelectedIndex = 0 Then
            sql = "select*from Table1 where id=" & TextBox6.Text & ""
        ElseIf ComboBox1.SelectedIndex = 1 Then
            sql = "select*from Table1 where name like '%" & TextBox6.Text & "%'"
        Else
            MsgBox("No Data Detect")
        End If
        da = New OleDbDataAdapter(sql, conn)
        'da.Fill(ds, "B")
        ds.Clear()
        da.Fill(ds, "Table1")
        DataGridView1.DataSource = ds.Tables(0)
        DataGridView1.Refresh()
    End Sub

    Private Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click, Button4.Click
        Dim frm As New Formreport
        frm.ShowDialog()


    End Sub
End Class