package br.com.fegssp.storewhitelabel.ui.products.addproduct

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import br.com.fegssp.storewhitelabel.databinding.FragmentAddProductBinding
import br.com.fegssp.storewhitelabel.util.CurrencyTextWatcher
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddProductFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentAddProductBinding? = null
    private val binding get() = _binding!!
    private var imgURI: Uri? = null
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            imgURI = uri
            binding.imgProduct.setImageURI(uri)
        }

    private val viewModel: AddProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        setListener()
    }

    private fun observe() {
        viewModel.imageUriErrorResId.observe(viewLifecycleOwner) { drawable ->
            binding.imgProduct.setBackgroundResource(drawable)
        }

        viewModel.descriptionErrorResId.observe(viewLifecycleOwner) { stringResId ->
            binding.inputLayoutDescription.setError(stringResId)
        }
        viewModel.priceErrorResId.observe(viewLifecycleOwner) { stringResId ->
            binding.inputLayoutPrice.setError(stringResId)
        }
    }

    private fun TextInputLayout.setError(stringResId: Int?) {
        error = if (stringResId != null) {
            getString(stringResId)
        } else null
    }

    private fun setListener() {
        binding.imgProduct.setOnClickListener {
            chooseImage()
        }

        binding.btnAdd.setOnClickListener {
            val description = binding.inputDescription.text.toString()
            val price = binding.inputPrice.text.toString()

            viewModel.createProduct(description,price,imgURI)
        }

        binding.inputPrice.run {
            addTextChangedListener(CurrencyTextWatcher(this))
        }
    }

    private fun chooseImage() {
        getContent.launch("image/*")
    }
}