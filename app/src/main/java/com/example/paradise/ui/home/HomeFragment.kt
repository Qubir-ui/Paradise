package com.example.paradise.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.paradise.LoadImage
import com.example.paradise.R
import com.example.paradise.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var loadImage: LoadImage
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        loadImage = LoadImage()
        val chair_1_view = binding.chair1
        val chair_2_view = binding.chair2
        val sofa_1_view = binding.sofa1
        val sofa_2_view = binding.sofa2
        val chest_1_view = binding.chest1
        val chest_2_view = binding.chest2
        val bed_1_view = binding.bed1
        val bed_2_view = binding.bed2
        val table_1_view = binding.table1
        val table_2_view = binding.table2
        val chair_1_url = "https://www.ikea.com/ru/ru/images/products/stefan-stul-belyy__0456421_pe604075_s5.jpg?f=xl"
        val chair_2_url = "https://www.ikea.com/ru/ru/images/products/odger-stul-siniy__0727322_pe735594_s5.jpg?f=xl"
        val sofa_1_url = "https://www.ikea.com/ru/ru/images/products/baeckseda-bekkseda-2-mestnyy-divan-krovat-sandsbru-temno-siniy__1023925_pe833357_s5.jpg?f=xl"
        val sofa_2_url = "https://www.ikea.com/ru/ru/images/products/klippan-2-mestnyy-divan-visle-siniy__0748016_pe744801_s5.jpg?f=xl"
        val chest_1_url = "https://www.ikea.com/ru/ru/images/products/malm-komod-s-2-yashchikami-cherno-korichnevyy__0651168_pe706780_s5.jpg?f=xl"
        val chest_2_url = "https://www.ikea.com/ru/ru/images/products/trysil-trisil-tumba-prikrovatnaya-temno-korichnevyy-chernyy__0624429_pe691836_s5.jpg?f=xl"
        val bed_1_url = "https://www.ikea.com/ru/ru/images/products/malm-karkas-krovati-2-krovatnyh-yashchika-dubovyy-shpon-belenyy-luroy__0638624_pe699041_s5.jpg?f=xl"
        val bed_2_url = "https://www.ikea.com/ru/ru/images/products/slattum-karkas-krovati-s-obivkoy-knisa-svetlo-seryy__0768244_pe754388_s5.jpg?f=xl"
        val table_1_url = "https://www.ikea.com/ru/ru/images/products/ingo-ingu-stol-sosna__20338_pe105501_s5.jpg?f=xl"
        val table_2_url = "https://www.ikea.com/ru/ru/images/products/lagkapten-adils-adils-pismennyy-stol-temno-seryy-chernyy__0977222_pe813466_s5.jpg?f=xl"
        try{
            loadImage.loadImage(chair_1_url, chair_1_view)
            loadImage.loadImage(chair_2_url, chair_2_view)
            loadImage.loadImage(sofa_1_url, sofa_1_view!!)
            loadImage.loadImage(sofa_2_url, sofa_2_view!!)
            loadImage.loadImage(chest_1_url, chest_1_view!!)
            loadImage.loadImage(chest_2_url, chest_2_view!!)
            loadImage.loadImage(bed_1_url, bed_1_view!!)
            loadImage.loadImage(bed_2_url, bed_2_view!!)
            loadImage.loadImage(table_1_url, table_1_view!!)
            loadImage.loadImage(table_2_url, table_2_view!!)
        }
        catch (e:Exception){
            Log.d("TAG", e.toString())
        }
        chair_1_view.setOnClickListener {
            val bundle = Bundle()
            val furniture_name = "chair_1"
            val furniture_url = chair_1_url
            bundle.putString("furniture_name", furniture_name)
            bundle.putString("furniture_url", furniture_url)
            view?.findNavController()?.navigate(R.id.action_navigation_home_to_furniture, bundle)
        }
        chair_2_view.setOnClickListener {
            val bundle = Bundle()
            val furniture_name = "chair_2"
            val furniture_url = chair_2_url
            bundle.putString("furniture_name", furniture_name)
            bundle.putString("furniture_url", furniture_url)
            view?.findNavController()?.navigate(R.id.action_navigation_home_to_furniture, bundle)
        }
        sofa_1_view?.setOnClickListener {
            val bundle = Bundle()
            val furniture_name = "sofa_1"
            val furniture_url = sofa_1_url
            bundle.putString("furniture_name", furniture_name)
            bundle.putString("furniture_url", furniture_url)
            view?.findNavController()?.navigate(R.id.action_navigation_home_to_furniture, bundle)
        }
        sofa_2_view?.setOnClickListener {
            val bundle = Bundle()
            val furniture_name = "sofa_2"
            val furniture_url = sofa_2_url
            bundle.putString("furniture_name", furniture_name)
            bundle.putString("furniture_url", furniture_url)
            view?.findNavController()?.navigate(R.id.action_navigation_home_to_furniture, bundle)
        }
        chest_1_view?.setOnClickListener {
            val bundle = Bundle()
            val furniture_name = "chest_1"
            val furniture_url = chest_1_url
            bundle.putString("furniture_name", furniture_name)
            bundle.putString("furniture_url", furniture_url)
            view?.findNavController()?.navigate(R.id.action_navigation_home_to_furniture, bundle)
        }
        chest_2_view?.setOnClickListener {
            val bundle = Bundle()
            val furniture_name = "chest_2"
            val furniture_url = chest_2_url
            bundle.putString("furniture_name", furniture_name)
            bundle.putString("furniture_url", furniture_url)
            view?.findNavController()?.navigate(R.id.action_navigation_home_to_furniture, bundle)
        }
        bed_1_view?.setOnClickListener {
            val bundle = Bundle()
            val furniture_name = "bed_1"
            val furniture_url = bed_1_url
            bundle.putString("furniture_name", furniture_name)
            bundle.putString("furniture_url", furniture_url)
            view?.findNavController()?.navigate(R.id.action_navigation_home_to_furniture, bundle)
        }
        bed_2_view?.setOnClickListener {
            val bundle = Bundle()
            val furniture_name = "bed_2"
            val furniture_url = bed_2_url
            bundle.putString("furniture_name", furniture_name)
            bundle.putString("furniture_url", furniture_url)
            view?.findNavController()?.navigate(R.id.action_navigation_home_to_furniture, bundle)
        }
        table_1_view?.setOnClickListener {
            val bundle = Bundle()
            val furniture_name = "table_1"
            val furniture_url = table_1_url
            bundle.putString("furniture_name", furniture_name)
            bundle.putString("furniture_url", furniture_url)
            view?.findNavController()?.navigate(R.id.action_navigation_home_to_furniture, bundle)
        }
        table_2_view?.setOnClickListener {
            val bundle = Bundle()
            val furniture_name = "table_2"
            val furniture_url = table_2_url
            bundle.putString("furniture_name", furniture_name)
            bundle.putString("furniture_url", furniture_url)
            view?.findNavController()?.navigate(R.id.action_navigation_home_to_furniture, bundle)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}