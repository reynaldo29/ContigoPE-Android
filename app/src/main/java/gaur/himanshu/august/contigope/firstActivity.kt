package gaur.himanshu.august.contigope
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.barteksc.pdfviewer.PDFView

import java.lang.Exception

class firstActivity : AppCompatActivity()  {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)
        val buton: Button = findViewById(R.id.shareButton)

        initViewModel()

        buton.setOnClickListener {
            sharePDF()
        }
    }

    private fun sharePDF() {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_STREAM, FileProvider.getUriForFile(
                    applicationContext, "gaur.himanshu.august.contigope.fileprovider",
                    viewModel.getPdfFileUri()
                ))
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            type = "application/pdf"
        }
        val sendIntent = Intent.createChooser(shareIntent, null)
        startActivity(sendIntent)
    }

    private fun initViewModel() {
        val bar :ProgressBar = findViewById(R.id.progressBar)
        var pdf :PDFView=findViewById(R.id.pdfView)
        viewModel = ViewModelProvider(this, object: ViewModelProvider.NewInstanceFactory() {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainActivityViewModel(fileDir = filesDir) as T
            }
        }).get(MainActivityViewModel::class.java)

        viewModel.isFileReadyObserver.observe(this, Observer <Boolean>{
            bar.visibility = View.GONE

            if(!it) {
                Toast.makeText(this@firstActivity, "Failed to download PDF", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@firstActivity, "PDF Downloaded successfully", Toast.LENGTH_LONG).show()
                try {
                    pdf.fromUri(
                        FileProvider.getUriForFile(
                            applicationContext,
                            "gaur.himanshu.august.contigope.fileprovider",
                            viewModel.getPdfFileUri()))
                        .load()
                }catch (e: Exception) {
                    Toast.makeText(this@firstActivity, "Failed to download PDF", Toast.LENGTH_LONG).show()

                }
            }
        })
        viewModel.downloadPdfFile("https://sprintbootapirest.herokuapp.com/api/pdf")
    }
}