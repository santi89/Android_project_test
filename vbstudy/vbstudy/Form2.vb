Public Class Form2
    Dim strend As Integer
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        strend = MsgBox("are you sure ?", MsgBoxStyle.OkCancel, "confirm exit !")
        If (strend = 1) Then
            End

        End If
    End Sub

    Private Sub Form2_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Label1.Text = ansstr1
    End Sub
End Class