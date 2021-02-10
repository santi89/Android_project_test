Public Class Form1
    Dim strend As Integer

    Private Sub Label2_Click(sender As Object, e As EventArgs) Handles Label2.Click

    End Sub

    Private Sub ComboBox1_SelectedIndexChanged(sender As Object, e As EventArgs) Handles ComboBox1.SelectedIndexChanged
        ListBox1.Items.Add(ComboBox1.SelectedItem)
    End Sub

    Private Sub CheckBox1_CheckedChanged(sender As Object, e As EventArgs) Handles CheckBox1.CheckedChanged
        If CheckBox1.Checked = True Then
            ListBox2.Items.Add("football")
            If CheckBox1.Checked = False Then
                ListBox2.Items.RemoveAt("football")
            End If
        End If

    End Sub

    Private Sub CheckBox2_CheckedChanged(sender As Object, e As EventArgs) Handles CheckBox2.CheckedChanged
        If CheckBox2.Checked = True Then
            ListBox2.Items.Add("basketball")
            If CheckBox2.Checked = False Then
                ListBox2.Items.RemoveAt("basketball")
            End If
        End If
    End Sub

    Private Sub CheckBox3_CheckedChanged(sender As Object, e As EventArgs) Handles CheckBox3.CheckedChanged
        If CheckBox3.Checked = True Then
            ListBox2.Items.Add("badminton")
            If CheckBox3.Checked = False Then
                ListBox2.Items.RemoveAt("badminton")
            End If
        End If
    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        If (TextBox1.Focus() = False Or TextBox1.Text = "") Then
            btstart.Enabled = False
        Else
            btstart.Enabled = True
        End If
    End Sub

    Private Sub GroupBox1_MouseHover(sender As Object, e As EventArgs) Handles GroupBox1.MouseHover
        If (TextBox1.Focus() = False Or TextBox1.Text = "") Then
            btstart.Enabled = False
        Else
            btstart.Enabled = True
        End If
    End Sub

    Private Sub btcencle_Click(sender As Object, e As EventArgs) Handles btcencle.Click
        TextBox1.Clear()
        TextBox2.Clear()

        ListBox1.Items.Clear()
        ListBox2.Items.Clear()

    End Sub

    Private Sub btexit_Click(sender As Object, e As EventArgs) Handles btexit.Click
        strend = MsgBox("are you sure ?", MsgBoxStyle.OkCancel, "confirm exit !")
        If (strend = 1) Then
            End

        End If
    End Sub

    Private Sub btstart_Click(sender As Object, e As EventArgs) Handles btstart.Click
        TextBox2.Text = TextBox1.Text

    End Sub

    Private Sub btnote_Click(sender As Object, e As EventArgs) Handles btnote.Click
        ansstr1 = rtbout.Text
        Form2.Show()

    End Sub

    Private Sub GroupBox2_Enter(sender As Object, e As EventArgs) Handles GroupBox2.Enter

    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        rtbout.AppendText("hello" & TextBox1.Text & vbNewLine)
        rtbout.AppendText(" food that you order" & ListBox1.SelectedItem & vbNewLine)
        rtbout.AppendText(" your activity is " & ListBox2.SelectedItem & vbNewLine)
        rtbout.AppendText(" ...................................." & vbNewLine)
    End Sub
End Class
