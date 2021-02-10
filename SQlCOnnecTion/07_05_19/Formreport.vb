Public Class Formreport

    Private Sub Formreport_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        'TODO: This line of code loads data into the 'vb_formDataSet1.Table1' table. You can move, or remove it, as needed.
        Me.Table1TableAdapter.Fill(Me.vb_formDataSet1.Table1)

        Me.ReportViewer1.RefreshReport()
    End Sub
End Class