Public Class addData

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Form1.DataGridView1.Rows.Add(txtid.Text, txtname.Text, txtsurname.Text, txtaddress.Text, txttel.Text)
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs)
        Form1.Visible = True
    End Sub

    Private Sub addData_Load(sender As Object, e As EventArgs) Handles MyBase.Load

    End Sub
End Class