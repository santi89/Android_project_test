Public Class homework_lab
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        If txtpcost.Text = "" Or txtpname.Text = "" Or txtpqty.Text = "" Or txtptotal.Text = "" Then
            MsgBox(" ກະ​ລຸ​ນາ​ປ້ອນ​ຂໍ້​ມູນໃຫ້​ຄົບ​ກ່ອນ ", MsgBoxStyle.OkOnly, " ແຈ້ງ​ເຕືອນ")
        Else
            '  ListBox1.Items.Add(" ຊື່​ສິນ​ຄ້າ  :" + txtpname.Text + "   ລາ​ຄາ     :" + txtpcost.Text + " ​   ຈຳ​ນວນ   : " + txtpqty.Text + "   ລວມ   : " + txtptotal.Text)

            Dim ite As New ListViewItem(txtpname.Text)
            ite.SubItems.Add(txtpcost.Text)
            ite.SubItems.Add(txtpqty.Text)
            ite.SubItems.Add(txtptotal.Text)
            ListView1.Items.Add(ite)
            txtAlltatol.Text = Val(txtptotal.Text) + Val(txtAlltatol.Text)
            txtpcost.Clear()
            txtpname.Clear()
            txtpqty.Clear()
            txtptotal.Clear()
        End If
    End Sub
    Private Sub txtpcost_KeyPress(sender As Object, e As KeyPressEventArgs) Handles txtpcost.KeyPress
        If Not IsNumeric(e.KeyChar) And Not e.KeyChar = ChrW(Keys.Back) Then
            e.Handled = True
        End If
    End Sub
  

    Private Sub txtpcost_TextChanged(sender As Object, e As EventArgs) Handles txtpcost.TextChanged       
            txtptotal.Text = Val(txtpcost.Text) * Val(txtpqty.Text)
    End Sub

    Private Sub txtpqty_KeyPress(sender As Object, e As KeyPressEventArgs) Handles txtpqty.KeyPress
        If Not IsNumeric(e.KeyChar) And Not e.KeyChar = ChrW(Keys.Back) Then
            e.Handled = True
        End If
    End Sub
    Private Sub txtpqty_TextChanged(sender As Object, e As EventArgs) Handles txtpqty.TextChanged
        txtptotal.Text = Val(txtpcost.Text) * Val(txtpqty.Text)

    End Sub

    Private Sub txtAlltatol_TextChanged(sender As Object, e As EventArgs) Handles txtAlltatol.TextChanged

    End Sub
End Class