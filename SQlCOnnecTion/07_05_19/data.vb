Imports System.Data.OleDb

Public Class data
    Dim conn As New OleDbConnection
    Dim da As New OleDbDataAdapter
    Dim ds As New DataSet
    Dim cmd As New OleDbCommand
    Dim stecon As String = " Provider=Microsoft.ACE.OLEDB.12.0;Data Source=vb_form.accdb"

    Private Sub data_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        conn = New OleDbConnection(strcom)
        conn.Open()
        showdata()
        DataGridView1.Columns(0).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
    End Sub
    Sub showdata()
        da = New OleDbDataAdapter("select *from Table1", conn)
        da.Fill(ds, "Table1")
        ds.Clear()
        da.Fill(ds, "Table1")
        DataGridView1.DataSource = ds.Tables("Table1")
        DataGridView1.DataSource = ds.Tables(0)
        DataGridView1.Refresh()
        'With DataGridView1
        '    .Columns(0).HeaderText = "ລະ​ຫັດ"
        '    .Columns(1).HeaderText = "ຊື່"
        '    .Columns(2).HeaderText = "ນາມ​ສ​ະ​ກູນ"
        '    .Columns(3).HeaderText = "​ທີ່​ຢູ່"
        '    .Columns(4).HeaderText = "ເບີ​ໂທ"
        '    .Columns(0).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
        '    .Columns(1).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
        '    .Columns(2).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
        '    .Columns(3).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
        '    .Columns(4).AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill
        'End With
        TextBox1.Text = ""
        TextBox2.Text = ""
        TextBox3.Text = ""
        TextBox4.Text = ""
        TextBox5.Text = ""

    End Sub

    Private Sub btsave_Click(sender As Object, e As EventArgs) Handles btsave.Click
        Dim add As String = ""
        add = "insert into Table1(Name,Surname,address,tel) values ('" & TextBox2.Text & "','" & TextBox3.Text & "','" & TextBox4.Text & "','" & TextBox5.Text & "')"
        cmd = New OleDbCommand(add, conn)
        cmd.ExecuteNonQuery()
        MsgBox("completed")
        showdata()
    End Sub

    Private Sub btdelete_Click(sender As Object, e As EventArgs) Handles btdelete.Click
        Dim del As String = ""
        del = "delete from Table1 where Name = '" & TextBox2.Text & "'"
        cmd = New OleDbCommand(del, conn)
        cmd.ExecuteNonQuery()
        MsgBox("completed")
        showdata()

    End Sub

    Private Sub btedit_Click(sender As Object, e As EventArgs) Handles btedit.Click
        Dim ed As String = ""
        ed = " update Table1 set Name ='" & TextBox2.Text & "',Surname='" & TextBox3.Text & "',address='" & TextBox4.Text & "',tel='" & TextBox5.Text & "' where ID = " & TextBox1.Text & ""
        cmd = New OleDbCommand(ed, conn)
        cmd.ExecuteNonQuery()
        MsgBox("complete")
        showdata()

    End Sub
    Private Sub DataGridView1_CellDoubleClick(sender As Object, e As DataGridViewCellEventArgs) Handles DataGridView1.CellDoubleClick
        TextBox1.Text = DataGridView1.Rows(DataGridView1.CurrentRow.Index).Cells(0).Value.ToString
        TextBox2.Text = DataGridView1.Rows(DataGridView1.CurrentRow.Index).Cells(1).Value.ToString
        TextBox3.Text = DataGridView1.Rows(DataGridView1.CurrentRow.Index).Cells(2).Value.ToString
        TextBox4.Text = DataGridView1.Rows(DataGridView1.CurrentRow.Index).Cells(3).Value.ToString
        TextBox5.Text = DataGridView1.Rows(DataGridView1.CurrentRow.Index).Cells(4).Value.ToString


    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim sql As String = ""
        If ComboBox1.SelectedIndex = 0 Then
            sql = "select*from Table1 where id=" & Tsearch.Text & ""
        ElseIf ComboBox1.SelectedIndex = 1 Then
            sql = "select*from Table1 where name like '%" & Tsearch.Text & "%'"
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

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        Dim frm As New Formre
        frm.Show()

    End Sub
End Class