Public Class Formre

    Private Sub Formre_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        'TODO: This line of code loads data into the 'vb_formDataSet2.Table1' table. You can move, or remove it, as needed.
        Me.Table1TableAdapter.Fill(Me.vb_formDataSet2.Table1)

        Me.ReportViewer1.RefreshReport()
    End Sub
End Class