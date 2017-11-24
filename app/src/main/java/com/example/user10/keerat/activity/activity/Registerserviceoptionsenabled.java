package com.example.user10.keerat.activity.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.IdRes;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.user10.keerat.R;
import com.example.user10.keerat.activity.Class.ConfigInfo;
import com.example.user10.keerat.activity.utils.DatePickerFragment;
import com.google.firebase.iid.FirebaseInstanceId;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static android.R.attr.bitmap;
import static android.R.attr.state_checked;

public class Registerserviceoptionsenabled extends AppCompatActivity {
    private TextView tvterms,etdatebirth;
    private EditText etfullname,  etaltermobile,  etpincode,etmobile,etemail,
                     etadd1,etadd2,etarea,etnearestgurudwara;
    private Button btnsubmit;
    private String fullname,dob,altmobile,pincode,mobile,emailid,address1,address2,area,
                   cty,deviceid,nearestgurudwara;
    private String usr;
    private  RadioGroup rggender;
    private  RadioButton rbmale,rbfemale;
    private static final int REQUEST_CODE_JOB = 1;
    private String encodedResume,gender;
   private AutoCompleteTextView atcity;
    private CheckBox cbox;


    String[] city = { "Mumbai","Delhi","Bengaluru","Ahmedabad","Gandhinagar","Hyderabad","Chennai",  "Kolkata",
            "Pune","Jaipur","Surat","Lucknow",  "Kanpur",  "Nagpur","Patna","Indore",  "Thane","Bhopal",
            "Visakhapatnam",  "Vadodara","Firozabad",  "Ludhiana","Rajkot","Agra",  "Siliguri",  "Nashik",
            "Faridabad","Patiala","Meerut",  "Kalyan-Dombivali","Vasai-Virar","Varanasi",  "Srinagar",
            "Dhanbad","Jodhpur","Amritsar","Raipur","Allahabad",  "Coimbatore",  "Jabalpur",  "Gwalior",
            "Vijayawada",  "Madurai",  "Guwahati","Chandigarh","Hubli-Dharwad","Amroha",  "Moradabad",  "Gurgaon",
            "Aligarh",  "Solapur","Ranchi","Jalandhar","Tiruchirappalli",  "Bhubaneswar","Salem",  "Warangal",
            "Mira-Bhayandar","Thiruvananthapuram","Bhiwandi","Saharanpur",  "Guntur",  "Amravati","Bikaner","Noida",
            "Jamshedpur","Bhilai Nagar","Cuttack","Kochi","Udaipur","Bhavnagar","Dehradun","Asansol",
            "Nanded-Waghala","Ajmer","Jamnagar","Ujjain",  "Sangli","Loni",  "Jhansi",  "Pondicherry","Nellore",
            "Jammu",  "Belagavi","Raurkela","Mangaluru","Tirunelveli",  "Malegaon","Gaya","Tiruppur",  "Davanagere",
            "Kozhikode","Akola","Kurnool",  "Bokaro Steel City","Rajahmundry",  "Ballari","Agartala","Bhagalpur",
            "Latur","Dhule","Korba","Bhilwara","Brahmapur","Mysore","Muzaffarpur","Ahmednagar","Kollam","Raghunathganj",
            "Bilaspur","Shahjahanpur",  "Thrissur","Alwar","Kakinada",  "Nizamabad","Sagar",  "Tumkur","Hisar","Rohtak",
            "Panipat","Darbhanga","Kharagpur",  "Aizawl","Ichalkaranji","Tirupati",  "Karnal","Bathinda","Rampur", "Shivamogga","Ratlam",  "Modinagar",  "Durg","Shillong",
            "Imphal","Hapur",  "Ranipet",  "Anantapur",  "Arrah","Karimnagar","Parbhani","Etawah",  "Bharatpur","Begusarai",
            "New Delhi","Chhapra","Kadapa",  "Ramagundam","Pali","Satna",  "Vizianagaram",  "Katihar","Hardwar","Sonipat",
            "Nagercoil",  "Thanjavur",  "Murwara (Katni)",  "Naihati",  "Sambhal",  "Nadiad","Yamunanagar","English Bazar",
            "Eluru",  "Munger","Panchkula","Raayachuru","Panvel","Deoghar","Ongole",  "Nandyal",  "Morena",  "Bhiwani",
            "Porbandar","Palakkad","Anand","Purnia","Baharampur",  "Barmer","Morvi","Orai",  "Bahraich",  "Sikar","Vellore",
            "Singrauli",  "Khammam","Mahesana","Silchar","Sambalpur","Rewa",  "Unnao",  "Hugli-Chinsurah",  "Raiganj",
            "Phusro","Adityapur","Alappuzha","Bahadurgarh","Machilipatnam",  "Rae Bareli",  "Jalpaiguri",  "Bharuch",
            "Pathankot","Hoshiarpur","Baramula",  "Adoni",  "Jind","Tonk","Tenali",  "Kancheepuram",  "Vapi","Sirsa",
            "Navsari","Mahbubnagar","Puri","Robertson Pet","Erode",  "Batala","Haldwani-cum-Kathgodam","Vidisha",  "Saharsa",
            "Thanesar","Chittoor",  "Veraval","Lakhimpur",  "Sitapur",  "Hindupur",  "Santipur",  "Balurghat",  "Ganjbasoda",
            "Moga","Proddatur",  "Srinagar","Medinipur",  "Habra",  "Sasaram","Hajipur","Bhuj","Shivpuri",  "Ranaghat",
            "Shimla",  "Tiruvannamalai",  "Kaithal","Rajnandgaon","Godhra","Hazaribag","Bhimavaram",  "Mandsaur",
            "Dibrugarh","Kolar","Bankura",  "Mandya","Dehri-on-Sone","Madanapalle",  "Malerkotla","Lalitpur",  "Bettiah",
            "Pollachi",  "Khanna","Neemuch",  "Palwal","Palanpur","Guntakal",  "Nabadwip",  "Udupi","Jagdalpur","Motihari",
            "Pilibhit",  "Dimapur","Mohali","Sadulpur","Rajapalayam",  "Dharmavaram",  "Kashipur","Sivakasi",  "Darjiling",
            "Chikkamagaluru","Gudivada",  "Baleshwar Town","Mancherial","Srikakulam",  "Adilabad","Yavatmal","Barnala",
            "Nagaon","Narasaraopet",  "Raigarh","Roorkee","Valsad","Ambikapur","Giridih","Chandausi",  "Purulia",  "Patan",
            "Bagaha","Hardoi ",  "Achalpur","Osmanabad","Deesa","Nandurbar","Azamgarh",  "Ramgarh","Firozpur","Baripada Town",
            "Karwar","Siwan","Rajampet",  "Pudukkottai",  "Anantnag",  "Tadpatri",  "Satara","Bhadrak","Kishanganj",
            "Suryapet","Wardha","Ranebennuru","Amreli","Neyveli (TS)",  "Jamalpur","Marmagao","Udgir","Tadepalligudem",
            "Nagapattinam",  "Buxar","Aurangabad","Jehanabad","Phagwara","Khair",  "Sawai Madhopur","Kapurthala",
            "Chilakaluripet",  "Aurangabad","Malappuram","Rewari","Nagaur","Sultanpur",  "Nagda",  "Port Blair",
            "Lakhisarai","Panaji","Tinsukia","Itarsi",  "Kohima","Balangir","Nawada","Jharsuguda","Jagtial","Viluppuram",
            "Amalner","Zirakpur","Tanda",  "Tiruchengode",  "Nagina",  "Yemmiganur",  "Vaniyambadi",  "Sarni",
            "Theni Allinagaram",  "Margao","Akot","Sehore",  "Mhow Cantonment",  "Kot Kapura","Makrana","Pandharpur",
            "Miryalaguda","Shamli",  "Seoni",  "Ranibennur","Kadiri",  "Shrirampur","Rudrapur","Parli","Najibabad",
            "Nirmal","Udhagamandalam",  "Shikohabad",  "Jhumri Tilaiya","Aruppukkottai",  "Ponnani","Jamui","Sitamarhi",
            "Chirala",  "Anjar","Karaikal","Hansi","Anakapalle",  "Mahasamund","Faridkot","Saunda","Dhoraji","Paramakudi",
            "Balaghat",  "Sujangarh","Khambhat","Muktsar","Rajpura","Kavali",  "Dhamtari","Ashok Nagar",  "Sardarshahar",
            "Mahuva","Bargarh","Kamareddy","Sahibganj","Kothagudem","Ramanagaram","Gokak","Tikamgarh",  "Araria","Rishikesh",
            "Shahdol",  "Medininagar (Daltonganj)","Arakkonam",  "Washim","Sangrur","Bodhan","Fazilka","Palacole",
            "Keshod","Sullurpeta",  "Wadhwan","Gurdaspur","Vatakara","Tura","Narnaul","Kharar","Yadgir","Ambejogai",
            "Ankleshwar","Savarkundla","Paradip","Virudhachalam",  "Kanhangad","Kadi","Srivilliputhur",  "Gobindgarh",
            "Tindivanam",  "Mansa","Taliparamba","Manmad","Tanuku",  "Rayachoti",  "Virudhunagar",  "Koyilandy","Jorhat",
            "Karur",  "Valparai",  "Srikalahasti",  "Neyyattinkara","Bapatla",  "Fatehabad","Malout","Sankarankovil",
            "Tenkasi",  "Ratnagiri","Rabkavi Banhatti","Sikandrabad",  "Chaibasa","Chirmiri","Palwancha","Bhawanipatna",
            "Kayamkulam","Pithampur",  "Nabha","Shahabad, Hardoi",  "Dhenkanal","Uran Islampur","Gopalganj",
            "Bongaigaon City","Palani",  "Pusad","Sopore",  "Pilkhuwa",  "Tarn Taran","Renukoot",  "Mandamarri",
            "Shahabad","Barbil","Koratla","Madhubani","Arambagh",  "Gohana","Ladnu","Pattukkottai",  "Sirsi","Sircilla",
            "Tamluk",  "Jagraon","AlipurdUrban Agglomerationr",  "Alirajpur",  "Tandur","Naidupet",  "Tirupathur",
            "Tohana","Ratangarh","Dhubri","Masaurhi","Visnagar","Vrindavan",  "Nokha","Nagari",  "Narwana","Ramanathapuram",
            "Ujhani",  "Samastipur","Laharpur",  "Sangamner","Nimbahera","Siddipet","Suri",  "Diphu","Jhargram",
            "Shirpur-Warwade","Tilhar",  "Sindhnur","Udumalaipettai",  "Malkapur","Wanaparthy","Gudur",
            "Kendujhar","Mandla",  "Mandi",  "Nedumangad","North Lakhimpur","Vinukonda",  "Tiptur","Gobichettipalayam",
            "Sunabeda","Wani","Upleta","Narasapuram",  "Nuzvid",  "Tezpur","Una","Markapur",  "Sheopur",  "Thiruvarur",
            "Sidhpur","Sahaswan",  "Suratgarh","Shajapur",  "Rayagada","Lonavla","Ponnur",  "Kagaznagar","Gadwal","Bhatapara",
            "Kandukur",  "Sangareddy","Unjha","Lunglei","Karimganj","Kannur","Bobbili",  "Mokameh","Talegaon Dabhade",
            "Anjangaon","Mangrol","Sunam","Gangarampur",  "Thiruvallur",  "Tirur","Rath",  "Jatani","Viramgam","Rajsamand",
            "Yanam","Kottayam","Panruti",  "Dhuri","Namakkal",  "Kasaragod","Modasa","Rayadurg",  "Supaul","Kunnamkulam",
            "Umred","Bellampalle","Sibsagar","Mandi Dabwali","Ottappalam","Dumraon","Samalkot",  "Jaggaiahpet",  "Goalpara",
            "Tuni",  "Lachhmangarh","Bhongir","Amalapuram",  "Firozpur Cantt.","Vikarabad","Thiruvalla","Sherkot",
            "Palghar","Shegaon","Jangaon","Bheemunipatnam",  "Panna",  "Thodupuzha","KathUrban Agglomeration",
            "Palitana","Arwal","Venkatagiri",  "Kalpi",  "Rajgarh (Churu)","Sattenapalle",  "Arsikere","Ozar","Thirumangalam",
            "Petlad","Nasirabad","Phaltan","Rampurhat",  "Nanjangud","Forbesganj","Tundla",  "BhabUrban Agglomeration",
            "Sagara","Pithapuram",  "Sira","Bhadrachalam","Charkhi Dadri","Chatra","Palasa Kasibugga",  "Nohar","Yevla",
            "Sirhind Fatehgarh Sahib","Bhainsa","Parvathipuram",  "Shahade","Chalakudy","Narkatiaganj","Kapadvanj","Macherla",
            "Raghogarh-Vijaypur",  "Rupnagar","Naugachhia","Sendhwa",  "Byasanagar","Sandila",  "Gooty",  "Salur",  "Nanpara",
            "Sardhana",  "Vita","Gumia","Puttur","Jalandhar Cantt.","Nehtaur",  "Changanassery","Mandapeta",  "Dumka",
            "Seohara",  "Umarkhed","Madhupur","Vikramasingapuram",  "Punalur","Kendrapara","Sihor","Nellikuppam",  "Samana",
            "Warora","Nilambur","Rasipuram",  "Ramnagar","Jammalamadugu",  "Nawanshahr","Thoubal","Athni","Cherthala","Sidhi",
            "Farooqnagar","Peddapuram",  "Chirkunda","Pachora","Madhepura","Pithoragarh","Tumsar","Phalodi","Tiruttani",
            "Rampura Phul","Perinthalmanna","Padrauna",  "Pipariya",  "Dalli-Rajhara","Punganur",  "Mattannur","Mathura",
            "Thakurdwara",  "Nandivaram-Guduvancheri",  "Mulbagal","Manjlegaon","Wankaner","Sillod","Nidadavole",  "Surapura",
            "Rajagangapur","Sheikhpura","Parlakhemundi","Kalimpong",  "Siruguppa","Arvi","Limbdi","Barpeta","Manglaur",
            "Repalle",  "Mudhol","Shujalpur",  "Mandvi","Thangadh","Sironj",  "Nandura","Shoranur","Nathdwara","Periyakulam",
            "Sultanganj","Medak","Narayanpet","Raxaul Bazar","Rajauri",  "Pernampattu",  "Nainital","Ramachandrapuram",
            "Vaijapur","Nangal","Sidlaghatta","Punch",  "Pandhurna",  "Wadgaon Road","Talcher","Varkala","Pilani","Nowgong",
            "Naila Janjgir","Mapusa","Vellakoil",  "Merta City","Sivaganga",  "Mandideep",  "Sailu","Vyara","Kovvur",
            "Vadalur",  "Nawabganj",  "Padra","Sainthia",  "Siana",  "Shahpur","Sojat","Noorpur",  "Paravoor","Murtijapur",
            "Ramnagar","Sundargarh","Taki",  "Saundatti-Yellamma","Pathanamthitta","Wadi","Rameshwaram",  "Tasgaon",
            "Sikandra Rao",  "Sihora",  "Tiruvethipuram",  "Tiruvuru",  "Mehkar","Peringathur","Perambalur",  "Manvi",
            "Zunheboto","Mahnar Bazar","Attingal","Shahbad","Puranpur",  "Nelamangala","Nakodar","Lunawada","Murshidabad",
            "Mahe","Lanka","Rudauli",  "Tuensang","Lakshmeshwar","Zira","Yawal","Thana Bhawan",  "Ramdurg","Pulgaon",
            "Sadasivpet","Nargund","Neem-Ka-Thana","Memari",  "Nilanga","Naharlagun",  "Pakaur","Wai","Tarikere","Malavalli",
            "Raisen",  "Lahar",  "Uravakonda",  "Savanur","Sirohi","Udhampur",  "Umarga","Pratapgarh","Lingsugur",
            "Usilampatti",  "Palia Kalan",  "Wokha","Rajpipla","Vijayapura","Rawatbhata","Sangaria","Paithan","Rahuri",
            "Patti","Zaidpur",  "Lalsot","Maihar",  "Vedaranyam",  "Nawapur","Solan",  "Vapi","Sanawad",  "Warisaliganj",
            "Revelganj","Sabalgarh",  "Tuljapur","Simdega","Musabani","Kodungallur","Phulabani","Umreth","Narsipatnam",
            "Nautanwa",  "Rajgir","Yellandu","Sathyamangalam",  "Pilibanga","Morshi","Pehowa","Sonepur","Pappinisseri",
            "Zamania",  "Mihijam","Purna","Puliyankudi",  "Shikarpur, Bulandshahr",  "Umaria",  "Porsa",  "Naugawan Sadat",
            "Fatehpur Sikri",  "Manuguru","Udaipur","Pipar City","Pattamundai","Nanjikottai",  "Taranagar","Yerraguntla",
            "Satana","Sherghati","Sankeshwara","Madikeri","Thuraiyur",  "Sanand","Rajula","Kyathampalle","Shahabad, Rampur",
            "Tilda Newra","Narsinghgarh",  "Chittur-Thathamangalam","Malaj Khand",  "Sarangpur",  "Robertsganj",  "Sirkali",
            "Radhanpur","Tiruchendur",  "Utraula",  "Patratu","Vijainagar, Ajmer","Periyasemur",  "Pathri","Sadabad",
            "Talikota","Sinnar","Mungeli","Sedam","Shikaripur","Sumerpur","Sattur",  "Sugauli","Lumding","Vandavasi",
            "Titlagarh","Uchgaon","Mokokchung","Paschim Punropara",  "Sagwara","Ramganj Mandi","Tarakeswar",
            "Mahalingapura","Dharmanagar","Mahemdabad","Manendragarh","Uran","Tharamangalam",  "Tirukkoyilur",
            "Pen","Makhdumpur","Maner","Oddanchatram",  "Palladam",  "Mundi",  "Nabarangapur","Mudalagi","Samalkha",
            "Nepanagar",  "Karjat","Ranavav","Pedana",  "Pinjore","Lakheri","Pasan",  "Puttur",  "Vadakkuvalliyur",
            "Tirukalukundram",  "Mahidpur",  "Mussoorie","Muvattupuzha","Rasra",  "Udaipurwati","Manwath","Adoor",
            "Uthamapalayam",  "Partur","Nahan",  "Ladwa","Mankachar","Nongstoin","Losal","Sri Madhopur","Ramngarh",
            "Mavelikkara","Rawatsar","Rajakhera","Lar",  "Lal Gopalganj Nindaura",  "Muddebihal","Sirsaganj",
            "Shahpura","Surandai",  "Sangole","Pavagada","Tharad","Mansa","Umbergaon","Mavoor","Nalbari","Talaja","Malur",
            "Mangrulpir","Soro","Shahpura","Vadnagar","Raisinghnagar","Sindhagi","Sanduru","Sohna","Manavadar","Pihani",
            "Safidon","Risod","Rosera","Sankari",  "Malpura","Sonamukhi",  "Shamsabad, Agra",  "Nokha",
            "PandUrban Agglomeration",  "Mainaguri",  "Afzalpur","Shirur","Salaya","Shenkottai",  "Pratapgarh","Vadipatti",
            "Nagarkurnool","Savner","Sasvad","Rudrapur",  "Soron",  "Sholingur",  "Pandharkaoda","Perumbavoor","Maddur",
            "Nadbai","Talode","Shrigonda","Madhugiri","Tekkalakote","Seoni-Malwa",  "Shirdi","SUrban Agglomerationr",
            "Terdal","Raver","Tirupathur",  "Taraori","Mukhed","Manachanallur",  "Rehli",  "Sanchore","Rajura","Piro",
            "Mudabidri","Vadgaon Kasba","Nagar","Vijapur","Viswanatham",  "Polur",  "Panagudi",  "Manawar",
            "Tehri","Samdhan",  "Pardi","Rahatgarh",  "Panagar",  "Uthiramerur",  "Tirora","Rangia","Sahjanwa",
            "Wara Seoni",  "Magadi","Rajgarh (Alwar)","Rafiganj","Tarana",  "Rampur Maniharan",  "Sheoganj","Raikot",
            "Pauri","Sumerpur",  "Navalgund","Shahganj",  "Marhaura","Tulsipur",  "Sadri","Thiruthuraipoondi",
            "Shiggaon","Pallapatti",  "Mahendragarh","Sausar",  "Ponneri",  "Mahad","Lohardaga","Tirwaganj",
            "Margherita","Sundarnagar",  "Rajgarh",  "Mangaldoi","Renigunta",  "Longowal","Ratia","Lalgudi",
            "Shrirangapattana","Niwari",  "Natham",  "Unnamalaikadai",  "PurqUrban Agglomerationzi",  "Shamsabad," +
            " Farrukhabad",  "Mirganj","Todaraisingh","Warhapur",  "Rajam",  "Urmar Tanda","Lonar","Powayan",
            "P.N.Patti",  "Palampur",  "Srisailam Project (Right Flank Colony) Township",  "Sindagi","Sandi",
            "Vaikom","Malda",  "Tharangambadi",  "Sakaleshapura","Lalganj","Malkangiri","Rapar","Mauganj",
            "Todabhim","Srinivaspur","Murliganj","Reengus","Sawantwadi","Tittakudi",  "Lilong","Rajaldesar",
            "Pathardi","Achhnera",  "Pacode",  "Naraura",  "Nakur",  "Palai","Morinda, India","Manasa",
            "Nainpur",  "Sahaspur",  "Pauni","Prithvipur",  "Ramtek","Silapathar","Songadh","Safipur",
            "Sohagpur",  "Mul","Sadulshahar","Phillaur","Sambhar","Prantij","Nagla","Pattran","Mount Abu","Reoti",
            "Tenu dam-cum-Kathhara","Panchla",  "Sitarganj","Pasighat",  "Motipur","O' Valley",  "Raghunathpur",
            "Suriyampalayam",  "Qadian","Rairangpur","Silvassa",  "Nowrozabad (Khodargama)",  "Mangrol","Soyagaon",
            "Sujanpur","Manihari","Sikanderpur",  "Mangalvedhe","Phulera","Ron","Sholavandan",  "Saidpur",  "Shamgarh",
            "Thammampatti",  "Maharajpur",  "Multai",  "Mukerian","Sirsi",  "Purwa",  "Sheohar","Namagiripettai",
            "Parasi",  "Lathi","Lalganj",  "Narkhed","Mathabhanga",  "Shendurjana","Peravurani",  "Mariani","Phulpur",
            "Rania","Pali",  "Pachore",  "Parangipettai",  "Pudupattinam",  "Panniyannur","Maharajganj","Rau",
            "Monoharpur",  "Mandawa","Marigaon","Pallikonda",  "Pindwara","Shishgarh",  "Patur","Mayang Imphal",
            "Mhowgaon",  "Guruvayoor","Mhaswad","Sahawar",  "Sivagiri",  "Mundargi","Punjaipugalur",  "Kailasahar",
            "Samthar",  "Sakti","Sadalagi","Silao","Mandalgarh","Loha","Pukhrayan",  "Padmanabhapuram",
            "Belonia","Saiha","Srirampore",  "Talwara","Puthuppally","Khowai","Vijaypur",  "Takhatgarh","Thirupuvanam",
            "Adra",  "Piriyapatna","Obra",  "Adalaj","Nandgaon","Barh",
            "Chhapra","Panamattom","Niwai",  "Bageshwar","Tarbha","Adyar","Narsinghgarh",  "Warud","Asarganj","Sarsod","Airdrie"
            ,"Grande Prairie"
            ,"Red Deer"
            ,"Beaumont"
            ,"Hanna"
            ,"St. Albert"
            ,"Bonnyville"
            ,"Hinton"
            ,"Spruce Grove"
            ,"Brazeau"
            ,"Irricana"
            ,"Strathcona County"
            ,"Breton"
            ,"Lacombe"
            ,"Strathmore"
            ,"Calgary"
            ,"Leduc"
            ,"Sylvan Lake"
            ,"Camrose"
            ,"Lethbridge"
            ,"Swan Hills"
            ,"Canmore"
            ,"McLennan"
            ,"Taber"
            ,"Didzbury"
            ,"Medicine Hat"
            ,"Turner Valley"
            ,"Drayton Valley"
            ,"Olds"
            ,"Vermillion"
            ,"Edmonton"
            ,"Onoway"
            ,"Wood Buffalo"
            ,"Ft. Saskatchewan"
            ,"Provost",
            "Burnaby"
            ,"Lumby"
            ,"City of Port Moody"
            ,"Cache Creek"
            ,"Maple Ridge"
            ,"Prince George"
            ,"Castlegar"
            ,"Merritt"
            ,"Prince Rupert"
            ,"Chemainus"
            ,"Mission"
            ,"Richmond"
            ,"Chilliwack"
            ,"Nanaimo"
            ,"Saanich"
            ,"Clearwater"
            ,"Nelson"
            ,"Sooke"
            ,"Colwood"
            ,"New Westminster"
            ,"Sparwood"
            ,"Coquitlam"
            ,"North Cowichan"
            ,"Surrey"
            ,"Cranbrook"
            ,"North Vancouver"
            ,"Terrace"
            ,"Dawson Creek"
            ,"North Vancouver"
            ,"Tumbler"
            ,"Delta"
            ,"Osoyoos"
            ,"Vancouver"
            ,"Fernie"
            ,"Parksville"
            ,"Vancouver"
            ,"Invermere"
            ,"Peace River"
            ,"Vernon"
            ,"Kamloops"
            ,"Penticton"
            ,"Victoria"
            ,"Kaslo"
            ,"Port Alberni"
            ,"Whistler"
            ,"Langley"
            ,"Port Hardy"
            ,"Birtle"
            ,"Flin Flon"
            ,"Swan River"
            ,"Brandon"
            ,"Snow Lake"
            ,"The Pas"
            ,"Cranberry Portage"
            ,"Steinbach"
            ,"Thompson"
            ,"Dauphin"
            ,"Stonewall"
            ,"Winnipeg"
            ,"Cap-Pele"
            ,"Miramichi"
            ,"Saint John"
            ,"Fredericton"
            ,"Moncton"
            ,"Saint Stephen"
            ,"Grand Bay-Westfield"
            ,"Oromocto"
            ,"Shippagan"
            ,"Grand Falls"
            ,"Port Elgin"
            ,"Sussex"
            ,"Memramcook"
            ,"Sackville"
            ,"Tracadie-Sheila"
            ,"Argentia"
            ,"Corner Brook"
            ,"Paradise"
            ,"Bishop's Falls"
            ,"Labrador City"
            ,"Portaux Basques"
            ,"Botwood"
            ,"Mount Pearl"
            ,"St. John's"
            ,"Brigus"
            ,"Town of Hay River"
            ,"Town of Inuvik"
            ,"Yellowknife"
            ,"Amherst"
            ,"Hants County"
            ,"Pictou"
            ,"Annapolis"
            ,"Inverness County"
            ,"Pictou County"
            ,"Argyle"
            ,"Kentville"
            ,"Queens"
            ,"Baddeck"
            ,"County of Kings"
            ,"Richmond"
            ,"Bridgewater"
            ,"Lunenburg"
            ,"Shelburne"
            ,"Cape Breton"
            ,"Lunenburg County"
            ,"Stellarton"
            ,"Chester"
            ,"Mahone Bay"
            ,"Truro"
            ,"Cumberland County"
            ,"New Glasgow"
            ,"Windsor"
            ,"East Hants"
            ,"New Minas"
            ,"Yarmouth"
            ,"Halifax"
            ,"Parrsboro"
            ,"Ajax"
            ,"Halton"
            ,"Peterborough"
            ,"Atikokan"
            ,"Halton Hills"
            ,"Pickering"
            ,"Barrie"
            ,"Hamilton"
            ,"Port Bruce"
            ,"Belleville"
            ,"Hamilton-Wentworth"
            ,"Port Burwell"
            ,"Blandford-Blenheim"
            ,"Hearst"
            ,"Port Colborne"
            ,"Blind River"
            ,"Huntsville"
            ,"Port Hope"
            ,"Brampton"
            ,"Ingersoll"
            ,"Prince Edward"
            ,"Brant"
            ,"James"
            ,"Quinte West"
            ,"Brantford"
            ,"Kanata"
            ,"Renfrew"
            ,"Brock"
            ,"Kincardine"
            ,"Richmond Hill"
            ,"Brockville"
            ,"King"
            ,"Sarnia"
            ,"Burlington"
            ,"Kingston"
            ,"Sault Ste. Marie"
            ,"Caledon"
            ,"Kirkland Lake"
            ,"Scarborough"
            ,"Cambridge"
            ,"Kitchener"
            ,"Scugog"
            ,"Chatham-Kent"
            ,"Larder Lake"
            ,"Souix Lookout CoC Sioux Lookout"
            ,"Chesterville"
            ,"Leamington"
            ,"Smiths Falls"
            ,"Clarington"
            ,"Lennox-Addington"
            ,"South-West Oxford"
            ,"Cobourg"
            ,"Lincoln"
            ,"St. Catharines"
            ,"Cochrane"
            ,"Lindsay"
            ,"St. Thomas"
            ,"Collingwood"
            ,"London"
            ,"Stoney Creek"
            ,"Cornwall"
            ,"Loyalist Township"
            ,"Stratford"
            ,"Cumberland"
            ,"Markham"
            ,"Sudbury"
            ,"Deep River"
            ,"Metro Toronto"
            ,"Temagami"
            ,"Dundas"
            ,"Merrickville"
            ,"Thorold"
            ,"Durham"
            ,"Milton"
            ,"Thunder Bay"
            ,"Dymond"
            ,"Nepean"
            ,"Tillsonburg"
            ,"Ear Falls"
            ,"Newmarket"
            ,"Timmins"
            ,"East Gwillimbury"
            ,"Niagara"
            ,"Toronto"
            ,"East Zorra-Tavistock"
            ,"Niagara Falls"
            ,"Uxbridge"
            ,"Elgin"
            ,"Niagara-on-the-Lake"
            ,"Vaughan"
            ,"Elliot Lake"
            ,"North Bay"
            ,"Wainfleet"
            ,"Flamborough"
            ,"North Dorchester"
            ,"Wasaga Beach"
            ,"Fort Erie"
            ,"North Dumfries"
            ,"Waterloo"
            ,"Fort Frances"
            ,"North York"
            ,"Waterloo"
            ,"Gananoque"
            ,"Norwich"
            ,"Welland"
            ,"Georgina"
            ,"Oakville"
            ,"Wellesley"
            ,"Glanbrook"
            ,"Orangeville"
            ,"West Carleton"
            ,"Gloucester"
            ,"Orillia"
            ,"West Lincoln"
            ,"Goulbourn"
            ,"Osgoode"
            ,"Whitby"
            ,"Gravenhurst"
            ,"Oshawa"
            ,"Wilmot"
            ,"Grimsby"
            ,"Ottawa"
            ,"Windsor"
            ,"Guelph"
            ,"Ottawa-Carleton"
            ,"Woolwich"
            ,"Haldimand-Norfork"
            ,"Owen Sound"
            ,"York"
            ,"Alberton"
            ,"Montague"
            ,"Stratford"
            ,"Charlottetown"
            ,"Souris"
            ,"Summerside"
            ,"Cornwall"
            ,"Alma"
            ,"Fleurimont"
            ,"Longueuil"
            ,"Amos"
            ,"Gaspe"
            ,"Marieville"
            ,"Anjou"
            ,"Gatineau"
            ,"Mount Royal"
            ,"Aylmer"
            ,"Hull"
            ,"Montreal"
            ,"Beauport"
            ,"Joliette"
            ,"Montreal Region"
            ,"Bromptonville"
            ,"Jonquiere"
            ,"Montreal-Est"
            ,"Brosssard"
            ,"Lachine"
            ,"Quebec"
            ,"Chateauguay"
            ,"Lasalle"
            ,"Saint-Leonard"
            ,"Chicoutimi"
            ,"Laurentides"
            ,"Sherbrooke"
            ,"Coaticook"
            ,"LaSalle"
            ,"Sorel"
            ,"Coaticook"
            ,"Laval"
            ,"Thetford Mines"
            ,"Dorval"
            ,"Lennoxville"
            ,"Victoriaville"
            ,"Drummondville"
            ,"Levis"
            ,"Avonlea"
            ,"Melfort"
            ,"Swift Current"
            ,"Colonsay"
            ,"Nipawin"
            ,"Tisdale"
            ,"Craik"
            ,"Prince Albert"
            ,"Unity"
            ,"Creighton"
            ,"Regina"
            ,"Weyburn"
            ,"Eastend"
            ,"Saskatoon"
            ,"Wynyard"
            ,"Esterhazy"
            ,"Shell Lake"
            ,"Yorkton"
            ,"Gravelbourg"
            , "Carcross"
            ,"Whitehorse","Aberdeen", "Abilene", "Akron", "Albany", "Albuquerque", "Alexandria", "Allentown", "Amarillo",
            "Anaheim", "Anchorage", "Ann Arbor", "Antioch", "Apple Valley", "Appleton", "Arlington", "Arvada",
            "Asheville", "Athens", "Atlanta", "Atlantic City", "Augusta", "Aurora", "Austin", "Bakersfield",
            "Baltimore", "Barnstable", "Baton Rouge", "Beaumont", "Bel Air", "Bellevue", "Berkeley", "Bethlehem",
            "Billings", "Birmingham", "Bloomington", "Boise", "Boise City", "Bonita Springs", "Boston", "Boulder",
            "Bradenton", "Bremerton", "Bridgeport", "Brighton", "Brownsville", "Bryan", "Buffalo", "Burbank",
            "Burlington", "Cambridge", "Canton", "Cape Coral", "Carrollton", "Cary", "Cathedral City", "Cedar Rapids",
            "Champaign", "Chandler", "Charleston", "Charlotte", "Chattanooga", "Chesapeake", "Chicago", "Chula Vista",
            "Cincinnati", "Clarke County", "Clarksville", "Clearwater", "Cleveland", "College Station",
            "Colorado Springs", "Columbia", "Columbus", "Concord", "Coral Springs", "Corona", "Corpus Christi",
            "Costa Mesa", "Dallas", "Daly City", "Danbury", "Davenport", "Davidson County", "Dayton", "Daytona Beach",
            "Deltona", "Denton", "Denver", "Des Moines", "Detroit", "Downey", "Duluth", "Durham", "El Monte", "El Paso",
            "Elizabeth", "Elk Grove", "Elkhart", "Erie", "Escondido", "Eugene", "Evansville", "Fairfield", "Fargo",
            "Fayetteville", "Fitchburg", "Flint", "Fontana", "Fort Collins", "Fort Lauderdale", "Fort Smith",
            "Fort Walton Beach", "Fort Wayne", "Fort Worth", "Frederick", "Fremont", "Fresno", "Fullerton",
            "Gainesville", "Garden Grove", "Garland", "Gastonia", "Gilbert", "Glendale", "Grand Prairie", "Grand Rapids",
            "Grayslake", "Green Bay", "GreenBay", "Greensboro", "Greenville", "Gulfport-Biloxi", "Hagerstown", "Hampton",
            "Harlingen", "Harrisburg", "Hartford", "Havre de Grace", "Hayward", "Hemet", "Henderson", "Hesperia",
            "Hialeah", "Hickory", "High Point", "Hollywood", "Honolulu", "Houma", "Houston", "Howell", "Huntington",
            "Huntington Beach", "Huntsville", "Independence", "Indianapolis", "Inglewood", "Irvine", "Irving", "Jackson",
            "Jacksonville", "Jefferson", "Jersey City", "Johnson City", "Joliet", "Kailua", "Kalamazoo", "Kaneohe",
            "Kansas City", "Kennewick", "Kenosha", "Killeen", "Kissimmee", "Knoxville", "Lacey", "Lafayette",
            "Lake Charles", "Lakeland", "Lakewood", "Lancaster", "Lansing", "Laredo", "Las Cruces", "Las Vegas",
            "Layton", "Leominster", "Lewisville", "Lexington", "Lincoln", "Little Rock", "Long Beach", "Lorain",
            "Los Angeles", "Louisville", "Lowell", "Lubbock", "Macon", "Madison", "Manchester", "Marina", "Marysville",
            "McAllen", "McHenry", "Medford", "Melbourne", "Memphis", "Merced", "Mesa", "Mesquite", "Miami", "Milwaukee",
            "Minneapolis", "Miramar", "Mission Viejo", "Mobile", "Modesto", "Monroe", "Monterey", "Montgomery",
            "Moreno Valley", "Murfreesboro", "Murrieta", "Muskegon", "Myrtle Beach", "Naperville", "Naples", "Nashua",
            "Nashville", "New Bedford", "New Haven", "New London", "New Orleans", "New York", "New York City",
            "Newark", "Newburgh", "Newport News", "Norfolk", "Normal", "Norman", "North Charleston", "North Las Vegas",
            "North Port", "Norwalk", "Norwich", "Oakland", "Ocala", "Oceanside", "Odessa", "Ogden", "Oklahoma City",
            "Olathe", "Olympia", "Omaha", "Ontario", "Orange", "Orem", "Orlando", "Overland Park", "Oxnard", "Palm Bay",
            "Palm Springs", "Palmdale", "Panama City", "Pasadena", "Paterson", "Pembroke Pines", "Pensacola", "Peoria",
            "Philadelphia", "Phoenix", "Pittsburgh", "Plano", "Pomona", "Pompano Beach", "Port Arthur", "Port Orange",
            "Port Saint Lucie", "Port St. Lucie", "Portland", "Portsmouth", "Poughkeepsie", "Providence", "Provo",
            "Pueblo", "Punta Gorda", "Racine", "Raleigh", "Rancho Cucamonga", "Reading", "Redding", "Reno", "Richland",
            "Richmond", "Richmond County", "Riverside", "Roanoke", "Rochester", "Rockford", "Roseville",
            "Round Lake Beach", "Sacramento", "Saginaw", "Saint Louis", "Saint Paul", "Saint Petersburg", "Salem",
            "Salinas", "Salt Lake City", "San Antonio", "San Bernardino", "San Buenaventura", "San Diego",
            "San Francisco", "San Jose", "Santa Ana", "Santa Barbara", "Santa Clara", "Santa Clarita", "Santa Cruz",
            "Santa Maria", "Santa Rosa", "Sarasota", "Savannah", "Scottsdale", "Scranton", "Seaside", "Seattle",
            "Sebastian", "Shreveport", "Simi Valley", "Sioux City", "Sioux Falls", "South Bend", "South Lyon",
            "Spartanburg", "Spokane", "Springdale", "Springfield", "St. Louis", "St. Paul", "St. Petersburg", "Stamford",
            "Sterling Heights", "Stockton", "Sunnyvale", "Syracuse", "Tacoma", "Tallahassee", "Tampa", "Temecula",
            "Tempe", "Thornton", "Thousand Oaks", "Toledo", "Topeka", "Torrance", "Trenton", "Tucson", "Tulsa",
            "Tuscaloosa", "Tyler", "Utica", "Vallejo", "Vancouver", "Vero Beach", "Victorville", "Virginia Beach",
            "Visalia", "Waco", "Warren", "Washington", "Waterbury", "Waterloo", "West Covina", "West Valley City", "Westminster",
            "Wichita", "Wilmington", "Winston", "Winter Haven", "Worcester", "Yakima", "Yonkers", "York", "Youngstown","Accrington",
            "Acton",
            "Adlington",
            "Alcester",
            "Aldeburgh",
            "Aldershot",
            "Aldridge",
            "Alford",
            "Alfreton",
            "Alnwick",
            "Alsager",
            "Alston",
            "Alton",
            "Altrincham",
            "Amble",
            "Amersham",
            "Amesbury",
            "Ampthill",
            "Andover",
            "Appleby-in-Westmorland",
            "Arundel",
            "Ashbourne",
            "Ashburton",
            "Ashby-de-la-Zouch",
            "Ashford",
            "Ashington",
            "Ashton-in-Makerfield",
            "Ashton-under-Lyne",
            "Askern",
            "Aspatria",
            "Atherstone",
            "Attleborough",
            "Axbridge",
            "Axminster",
            "Aylesbury",
            "Aylsham",
            "Bacup",
            "Bakewell",
            "Baldock",
            "Banbury",
            "Barking",
            "Barnard Castle",
            "Barnet",
            "Barnoldswick",
            "Barnsley",
            "Barnstaple",
            "Barnt Green",
            "Barrow-in-Furness",
            "Barton-upon-Humber",
            "Basildon",
            "Basingstoke",
            "Bath",
            "Batley",
            "Battle",
            "Bawtry",
            "Beaconsfield",
            "Beaminster",
            "Bebington",
            "Beccles",
            "Bedale",
            "Bedford",
            "Bedlington",
            "Bedworth",
            "Beeston",
            "Belper",
            "Bentham",
            "Berkhamsted",
            "Berwick-upon-Tweed",
            "Beverley",
            "Bewdley",
            "Bexhill-on-Sea",
            "Bicester",
            "Biddulph",
            "Bideford",
            "Biggleswade",
            "Billericay",
            "Bilston",
            "Bingham",
            "Birmingham",
            "Bishop Auckland",
            "Bishop Castle",
            "Bishop Stortford",
            "Bishop Waltham",
            "Blackburn",
            "Blackpool",
            "Blandford Forum",
            "Bletchley",
            "Blyth",
            "Bodmin",
            "Bognor Regis",
            "Bollington",
            "Bolsover",
            "Bolton",
            "Borehamwood",
            "Boston",
            "Bottesford",
            "Bourne",
            "Bournemouth",
            "Brackley",
            "Bracknell",
            "Bradford",
            "Bradford-on-Avon",
            "Bradley Stoke",
            "Bradninch",
            "Braintree",
            "Brentford",
            "Brentwood",
            "Bridgnorth",
            "Bridgwater",
            "Bridlington",
            "Bridport",
            "Brierley Hill",
            "Brigg",
            "Brighouse",
            "Brightlingsea",
            "Brighton",
            "Bristol",
            "Brixham",
            "Broadstairs",
            "Bromley",
            "Bromsgrove",
            "Bromyard",
            "Brownhills",
            "Buckfastleigh",
            "Buckingham",
            "Bude",
            "Budleigh Salterton",
            "Bungay",
            "Buntingford",
            "Burford",
            "Burgess Hill",
            "Burnham-on-Crouch",
            "Burnham-on-Sea",
            "Burnley",
            "Burntwood",
            "Burton Latimer",
            "Burton-upon-Trent",
            "Bury",
            "Bury St Edmunds",
            "Buxton",
            "Caistor",
            "Calne",
            "Camberley",
            "Camborne",
            "Cambridge",
            "Camelford",
            "Cannock",
            "Canterbury",
            "Carlisle",
            "Carnforth",
            "Carterton",
            "Castle Cary",
            "Castleford",
            "Chadderton",
            "Chagford",
            "Chard",
            "Charlbury",
            "Chatham",
            "Chatteris",
            "Chelmsford",
            "Cheltenham",
            "Chesham",
            "Cheshunt",
            "Chester",
            "Chesterfield",
            "Chester-le-Street",
            "Chichester",
            "Chippenham",
            "Chipping Campden",
            "Chipping Norton",
            "Chipping Ongar",
            "Chipping Sodbury",
            "Chorley",
            "Christchurch",
            "Church Stretton",
            "Cinderford",
            "Cirencester",
            "Clacton-on-Sea",
            "Cleckheaton",
            "Cleethorpes",
            "Clevedon",
            "Clitheroe",
            "Clun",
            "Coalville",
            "Cockermouth",
            "Coggeshall",
            "Colchester",
            "Coleford",
            "Colne",
            "Congleton",
            "Conisbrough",
            "Corbridge",
            "Corby",
            "Cotgrave",
            "Coventry",
            "Cowes",
            "Cramlington",
            "Crawley",
            "Crayford",
            "Crediton",
            "Crewe",
            "Crewkerne",
            "Cromer",
            "Crowborough",
            "Crowle",
            "Crowthorne",
            "Croydon",
            "Cuckfield",
            "Cullompton",
            "Dagenham",
            "Darley Dale",
            "Darlington",
            "Dartford",
            "Dartmouth",
            "Darwen",
            "Daventry",
            "Dawlish",
            "Deal",
            "Denton",
            "Derby",
            "Dereham",
            "Desborough",
            "Devizes",
            "Dewsbury",
            "Didcot",
            "Dinnington",
            "Diss",
            "Doncaster",
            "Dorchester",
            "Dorking",
            "Dover",
            "Downham Market",
            "Driffield",
            "Dronfield",
            "Droitwich Spa",
            "Droylsden",
            "Dudley",
            "Dukinfield",
            "Dunstable",
            "Durham",
            "Dursley",
            "Ealing",
            "Earley",
            "Easingwold",
            "Eastbourne",
            "East Grinstead",
            "East Ham",
            "Eastleigh",
            "Eastwood",
            "Edenbridge",
            "Egham",
            "Ellesmere",
            "Ellesmere Port",
            "Ely",
            "Enfield",
            "Epping",
            "Epsom",
            "Epworth",
            "Erith",
            "Esher",
            "Eton",
            "Evesham",
            "Exeter",
            "Exmouth",
            "Eye",
            "Failsworth",
            "Fairford",
            "Fakenham",
            "Falmouth",
            "Fareham",
            "Faringdon",
            "Farnborough",
            "Farnham",
            "Farnworth",
            "Faversham",
            "Featherstone",
            "Felixstowe",
            "Fenny Stratford",
            "Ferndown",
            "Ferryhill",
            "Filey",
            "Filton",
            "Fleet",
            "Fleetwood",
            "Flitwick",
            "Folkestone",
            "Fordingbridge",
            "Fordwich",
            "Fowey",
            "Framlingham",
            "Frinton-on-Sea",
            "Frodsham",
            "Frome",
            "Gainsborough",
            "Gateshead",
            "Gillingham",
            "Gillingham",
            "Glastonbury",
            "Glossop",
            "Gloucester",
            "Godalming",
            "Godmanchester",
            "Goole",
            "Gosport",
            "Grange-over-Sands",
            "Grantham",
            "Gravesend",
            "Grays",
            "Great Dunmow",
            "Great Torrington",
            "Great Yarmouth",
            "Grimsby",
            "Guildford",
            "Guisborough",
            "Hackney",
            "Hadleigh",
            "Hailsham",
            "Halesworth",
            "Halewood",
            "Halifax",
            "Halstead",
            "Haltwhistle",
            "Harlow",
            "Harpenden",
            "Harrogate",
            "Harrow",
            "Hartlepool",
            "Harwich",
            "Haslemere",
            "Hastings",
            "Hatfield",
            "Havant",
            "Haverhill",
            "Hawley",
            "Hayle",
            "Haywards Heath",
            "Heanor",
            "Heathfield",
            "Hebden Bridge",
            "Hedon",
            "Helston",
            "Hemel Hempstead",
            "Hemsworth",
            "Henley-in-Arden",
            "Henley-on-Thames",
            "Hendon",
            "Hereford",
            "Herne Bay",
            "Hertford",
            "Hessle",
            "Heswall",
            "Hetton-le-Hole",
            "Heywood",
            "Hexham",
            "Higham Ferrers",
            "Highworth",
            "High Wycombe",
            "Hinckley",
            "Hitchin",
            "Hoddesdon",
            "Holmfirth",
            "Holsworthy",
            "Honiton",
            "Horley",
            "Horncastle",
            "Hornsea",
            "Horsham",
            "Horwich",
            "Houghton-le-Spring",
            "Hounslow",
            "Hoylake",
            "Hove Hucknall",
            "Huddersfield",
            "Hugh Town",
            "Hungerford",
            "Hunstanton",
            "Huntingdon",
            "Hyde",
            "Hythe",
            "Ilchester",
            "Ilford",
            "Ilfracombe",
            "Ilkeston",
            "Ilkley",
            "Ilminster",
            "Ipswich",
            "Irthlingborough",
            "Ivybridge",
            "Jarrow",
            "Keighley",
            "Kempston",
            "Kendal",
            "Kenilworth",
            "Kesgrave",
            "Keswick",
            "Kettering",
            "Keynsham",
            "Kidderminster",
            "Kidsgrove",
            "Killingworth",
            "Kimberley",
            "Kingsbridge",
            "King Lynn",
            "Kingston-upon-Hull",
            "Kingston upon Thames",
            "Kington",
            "Kirkby",
            "Kirkby Lonsdale",
            "Kirkham",
            "Knaresborough",
            "Knottingley",
            "Knutsford",
            "Lancaster",
            "Launceston",
            "Leatherhead",
            "Leamington Spa",
            "Lechlade",
            "Ledbury",
            "Leeds",
            "Leek",
            "Leicester",
            "Leighton Buzzard",
            "Leiston",
            "Leominster",
            "Letchworth",
            "Lewes",
            "Lewisham",
            "Leyland",
            "Leyton",
            "Lichfield",
            "Lincoln",
            "Liskeard",
            "Littlehampton",
            "Liverpool",
            "Lizard",
            "London",
            "Long Eaton",
            "Longridge",
            "Looe",
            "Lostwithiel",
            "Loughborough",
            "Loughton",
            "Louth",
            "Lowestoft",
            "Ludlow",
            "Luton",
            "Lutterworth",
            "Lydd",
            "Lydney",
            "Lyme Regis",
            "Lymington",
            "Lynton",
            "Lytchett Minster",
            "Lytham St Annes",
            "Mablethorpe",
            "Macclesfield",
            "Maghull",
            "Maidenhead",
            "Maidstone",
            "Maldon",
            "Malmesbury",
            "Maltby",
            "Malton",
            "Malvern",
            "Manchester",
            "Manningtree",
            "Mansfield",
            "March",
            "Margate",
            "Market Deeping",
            "Market Drayton",
            "Market Harborough",
            "Market Rasen",
            "Market Weighton",
            "Marlborough",
            "Marlow",
            "Maryport",
            "Matlock",
            "Melksham",
            "Melton Mowbray",
            "Mexborough",
            "Middleham",
            "Middlesbrough",
            "Middleton",
            "Middlewich",
            "Midhurst",
            "Midsomer Norton",
            "Milton Keynes",
            "Minehead",
            "Morecambe",
            "Moretonhampstead",
            "Moreton-in-Marsh",
            "Morley",
            "Morpeth",
            "Much Wenlock",
            "Nailsea",
            "Nailsworth",
            "Nantwich",
            "Needham Market",
            "Neston",
            "Newark-on-Trent",
            "Newbiggin-by-the-Sea",
            "Newbury",
            "Newcastle-under-Lyme",
            "Newcastle upon Tyne",
            "Newent",
            "Newhaven",
            "Newmarket",
            "New Mills",
            "New Milton",
            "Newport",
            "Newport",
            "Shropshire",
            "Newport Pagnell",
            "Newquay",
            "New Romney",
            "Newton Abbot",
            "Newton Aycliffe",
            "Newton-le-Willows",
            "Normanton",
            "Northallerton",
            "Northam",
            "Northampton",
            "North Walsham",
            "Northwich",
            "Norton Radstock",
            "Norwich",
            "Nottingham",
            "Nuneaton",
            "Oakham",
            "Okehampton",
            "Oldbury",
            "Oldham",
            "Ollerton",
            "Olney",
            "Ormskirk",
            "Orpington",
            "Ossett",
            "Oswestry",
            "Otley",
            "Ottery St Mary",
            "Oundle",
            "Oxford",
            "Paddock Wood",
            "Padstow",
            "Paignton",
            "Painswick",
            "Peacehaven",
            "Penistone",
            "Penrith",
            "Penryn",
            "Penzance",
            "Pershore",
            "Peterborough",
            "Peterlee",
            "Petersfield",
            "Petworth",
            "Pickering",
            "Plymouth",
            "Pocklington",
            "Pontefract",
            "Polegate",
            "Poltimore",
            "Poole",
            "Portishead",
            "Portland",
            "Portslade",
            "Portsmouth",
            "Potters Bar",
            "Potton",
            "Poulton-le-Fylde",
            "Prescot",
            "Preston",
            "Princes Risborough",
            "Prudhoe",
            "Pudsey",
            "Queenborough",
            "Ramsgate",
            "Raunds",
            "Rayleigh",
            "Reading",
            "Redcar",
            "Redditch",
            "Redhill",
            "Redruth",
            "Reigate",
            "Retford",
            "Richmond",
            "Richmond-upon-Thames",
            "Rickmansworth",
            "Ringwood",
            "Ripley",
            "Ripon",
            "Rochdale",
            "Rochester",
            "Rochford",
            "Romford",
            "Romsey",
            "Ross-on-Wye",
            "Rothbury",
            "Rotherham",
            "Rothwell",
            "Rowley Regis",
            "Royston",
            "Rugby",
            "Rugeley",
            "Runcorn",
            "Rushden",
            "Ryde",
            "Rye",
            "Saffron Walden",
            "St Albans",
            "St Austell",
            "St Blazey",
            "St Columb Major",
            "St Helens",
            "St Ives",
            "Cambridgeshire",
            "St Ives",
            "Cornwall",
            "St Neots",
            "Salcombe",
            "Sale",
            "Salford",
            "Salisbury",
            "Saltash",
            "Saltburn-by-the-Sea",
            "Sandbach",
            "Sandhurst",
            "Sandown",
            "Sandwich",
            "Sandy",
            "Sawbridgeworth",
            "Saxmundham",
            "Scarborough",
            "Scunthorpe",
            "Seaford",
            "Seaton",
            "Sedgefield",
            "Selby",
            "Selsey",
            "Settle",
            "Sevenoaks",
            "Shaftesbury",
            "Shanklin",
            "Sheerness",
            "Sheffield",
            "Shepshed",
            "Shepton Mallet",
            "Sherborne",
            "Sheringham",
            "Shildon",
            "Shipston-on-Stour",
            "Shoreham-by-Sea",
            "Shrewsbury",
            "Sidmouth",
            "Sittingbourne",
            "Skegness",
            "Skelmersdale",
            "Skipton",
            "Sleaford",
            "Slough",
            "Smethwick",
            "Snodland",
            "Soham",
            "Solihull",
            "Somerton",
            "Southall",
            "Southam",
            "Southampton",
            "Southborough",
            "Southend-on-Sea",
            "South Molton",
            "Southport",
            "Southsea",
            "South Shields",
            "Southwell",
            "Southwold",
            "South Woodham Ferrers",
            "Spalding",
            "Spennymoor",
            "Spilsby",
            "Stafford",
            "Staines",
            "Stainforth",
            "Stalybridge",
            "Stamford",
            "Stanley",
            "Stapleford",
            "Staunton",
            "Staveley",
            "Stevenage",
            "Stockport",
            "Stocksbridge",
            "Stockton-on-Tees",
            "Stoke-on-Trent",
            "Stone",
            "Stony Stratford",
            "Stotfield",
            "Stourbridge",
            "Stourport-on-Severn",
            "Stowmarket",
            "Stow-on-the-Wold",
            "Stratford-upon-Avon",
            "Streatham",
            "Strood",
            "Stroud",
            "Sudbury",
            "Sunderland",
            "Sutton",
            "Sutton Coldfield",
            "Sutton-in-Ashfield",
            "Swadlincote",
            "Swaffham",
            "Swanage",
            "Swanley",
            "Swindon",
            "Swinton",
            "Tadcaster",
            "Tadley",
            "Tamworth",
            "Taunton",
            "Tavistock",
            "Teignmouth",
            "Telford",
            "Tenbury Wells",
            "Tenterden",
            "Tetbury",
            "Tewkesbury",
            "Thame",
            "Thatcham",
            "Thaxted",
            "Thetford",
            "Thirsk",
            "Thong",
            "Thornaby",
            "Thornbury",
            "Thorne",
            "Tickhill",
            "Tilbury",
            "Tipton",
            "Tiverton",
            "Todmorden",
            "Tonbridge",
            "Torpoint",
            "Torquay",
            "Totnes",
            "Tottenham",
            "Totton",
            "Towcester",
            "Tring",
            "Trowbridge",
            "Truro",
            "Tunbridge Wells",
            "Twickenham",
            "Uckfield",
            "Ulverston",
            "Uppingham",
            "Upton-upon-Severn",
            "Uttoxeter",
            "Uxbridge",
            "Ventnor",
            "Verwood",
            "Wadebridge",
            "Wadhurst",
            "Wakefield",
            "Wallasey",
            "Wallingford",
            "Walmer",
            "Walsall",
            "Waltham Abbey",
            "Waltham Cross",
            "Walthamstow",
            "Walton-on-Thames",
            "Walton-on-the-Naze",
            "Wandsworth",
            "Wantage",
            "Ware",
            "Wareham",
            "Warminster",
            "Warrington",
            "Warwick",
            "Washington",
            "Watchet",
            "Watford",
            "Wath-upon-Dearne",
            "Watton",
            "Wednesbury",
            "Wellingborough",
            "Wellington",
            "Wells",
            "Wells-next-the-Sea",
            "Welwyn Garden City",
            "Wem",
            "Wendover",
            "West Bromwich",
            "Westbury",
            "Westerham",
            "West Ham",
            "Westhoughton",
            "West Kirby",
            "West Mersea",
            "Westminster",
            "Weston-super-Mare",
            "Westward Ho!",
            "Wetherby",
            "Weybridge",
            "Weymouth",
            "Whaley Bridge",
            "Whiston",
            "Whitby",
            "Whitchurch",
            "Whitehaven",
            "Whitley Bay",
            "Whitnash",
            "Whitstable",
            "Whitworth",
            "Wickford",
            "Widnes",
            "Wigan",
            "Wigston",
            "Willenhall",
            "Wimbledon",
            "Wimborne Minster",
            "Wincanton",
            "Winchcombe",
            "Winchelsea",
            "Winchester",
            "Windermere",
            "Winsford",
            "Winslow",
            "Wisbech",
            "Witham",
            "Withernsea",
            "Witney",
            "Wivenhoe",
            "Woburn",
            "Woking",
            "Wokingham",
            "Wolverhampton",
            "Wombwell",
            "Woodbridge",
            "Woodstock",
            "Wooler",
            "Woolwich",
            "Wootton Bassett",
            "Worcester",
            "Workington",
            "Worksop",
            "Worthing",
            "Wotton-under-Edge",
            "Wycombe",
            "Wymondham",
            "Acton",
            "Aghacommon",
            "Aghadowey",
            "Aghadrumsee",
            "Aghagallon",
            "Aghalee",
            "Ahoghill",
            "Aldergrove",
            "Altamuskin",
            "Altishane",
            "Altmore",
            "Annaclone",
            "Annaghmore",
            "Annahilt",
            "Annahugh",
            "Annalong",
            "Annsborough",
            "Antrim",
            "Ardboe",
            "Ardgarvan",
            "Ardglass",
            "Ardmore",
            "Ardstraw",
            "Armagh",
            "Armoy",
            "Arney",
            "Articlave",
            "Artigarvan",
            "Artikelly",
            "Atticall",
            "Aughafatten",
            "Augher",
            "Aughnacloy",
            "Ballela",
            "Ballerin",
            "Ballinamallard",
            "Ballintoy",
            "Balloo",
            "Ballybogy",
            "Ballycarry",
            "Ballycassidy",
            "Ballycastle",
            "Ballyclare",
            "Ballyeaston",
            "Ballygalley",
            "Ballygawley",
            "Ballygowan",
            "Ballyhalbert",
            "Ballyhornan",
            "Ballykelly",
            "Ballykinler",
            "Ballylesson",
            "Ballylinney",
            "Ballymacmaine",
            "Ballymacnab",
            "Ballymagorry",
            "Ballymartin",
            "Ballymaguigan",
            "Ballymena",
            "Ballymoney",
            "Ballynahinch",
            "Ballynure",
            "Ballyrashane",
            "Ballyrobert",
            "Ballyronan",
            "Ballyrory",
            "Ballyscullion",
            "Ballyskeagh",
            "Ballystrudder",
            "Ballyvoy",
            "Ballywalter",
            "Balnamore",
            "Banagher",
            "Banbridge",
            "Bangor",
            "Bannfoot",
            "Belcoo",
            "Bellaghy",
            "Bellanaleck",
            "Bellarena",
            "Belleek",
            "Belleeks",
            "Benburb",
            "Bendooragh",
            "Beragh",
            "Bessbrook",
            "Blackskull",
            "Blackwatertown",
            "Blaney",
            "Bleary",
            "Boho",
            "Brackaville",
            "Bready",
            "Brockagh",
            "Brookeborough",
            "Broomhill",
            "Broughshane",
            "Bryansford",
            "Buckna",
            "Burnfoot",
            "Burren",
            "Bushmills",
            "Caledon",
            "Camlough",
            "Campsey",
            "Capecastle",
            "Cappagh",
            "Cargan",
            "Carnalbanagh",
            "Carncastle",
            "Carnlough",
            "Carnteel",
            "Carrickaness",
            "Carrickfergus",
            "Carrickmore",
            "Carrowclare",
            "Carrowdore",
            "Carrybridge",
            "Carryduff",
            "Castlecaulfield",
            "Castledawson",
            "Castlederg",
            "Castlerock",
            "Castlewellan",
            "Charlemont",
            "Clabby",
            "Clady (Co. Londonderry)",
            "Clady (Co. Tyrone)",
            "Cladymore",
            "Clanabogan",
            "Claudy",
            "Clogh",
            "Clogher",
            "Cloghy",
            "Clonmore",
            "Clonoe",
            "Clough",
            "Cloughmills",
            "Coagh",
            "Coalisland",
            "Cogry-Kilbride",
            "Coleraine",
            "Collegeland",
            "Comber",
            "(convoy) Conlig",
            "Cookstown",
            "Corbet",
            "Corrinshego",
            "Craigarogan",
            "Craigavon",
            "Cranagh",
            "Crawfordsburn",
            "Creagh",
            "Creggan",
            "Crossgar",
            "Crossmaglen",
            "Crumlin",
            "Cullaville",
            "Cullybackey",
            "Cullyhanna",
            "Culmore",
            "Culnady",
            "Curran",
            "Cushendall",
            "Cushendun",
            "Darkley",
            "Derryadd",
            "Derrycrin",
            "Derrygonnelly",
            "Derryhale",
            "Derrylin",
            "Derrymacash",
            "Derrymore",
            "Derrynaflaw",
            "Derrynoose",
            "Derrytrasna",
            "Derryvore",
            "Dervock",
            "Desertmartin",
            "Doagh",
            "Dollingstown",
            "Donagh",
            "Donaghadee",
            "Donaghcloney",
            "Donaghey",
            "Donaghmore",
            "Donegore",
            "Dooish",
            "Dorsy",
            "Douglas Bridge",
            "Downhill",
            "Downpatrick",
            "Draperstown",
            "Drinns Bay",
            "Dromara",
            "Dromore (Co. Down)",
            "Dromore (Co. Tyrone)",
            "Drumaness",
            "Drumbeg",
            "Drumbo",
            "Drumintee",
            "Drumlaghy",
            "Drumlough",
            "Drumlough",
            "Drummullan",
            "Drumnacanvy",
            "Drumnakilly",
            "Drumquin",
            "Drumraighland",
            "Drumsurn",
            "Dunadry",
            "Dundonald",
            "Dundrod",
            "Dundrum",
            "Dungannon",
            "Dungiven",
            "Dunloy",
            "Dunnamanagh",
            "Dunnamore",
            "Dunnaval",
            "Dunseverick",
            "Edenaveys",
            "Edenderry",
            "Ederney",
            "Eglinton",
            "Eglish",
            "Enniskillen",
            "Erganagh",
            "Eskra",
            "Feeny",
            "Fintona",
            "Fivemiletown",
            "Florencecourt",
            "Foreglen",
            "Forkill",
            "Galbally",
            "Gamblestown",
            "Garrison",
            "Garvagh",
            "Garvaghey",
            "Garvetagh",
            "Gawleys Gate",
            "Gibsons Hill",
            "Gilford",
            "Gillygooly",
            "Glack",
            "Glebe",
            "Glenarm",
            "Glenavy",
            "Glenmornan",
            "Glenoe",
            "Glenone",
            "Glynn",
            "Gortaclare",
            "Gortin",
            "Gortnahey",
            "Goshedan",
            "Gracehill",
            "Grange Corner",
            "Granville",
            "Greencastle",
            "Greenisland",
            "Greyabbey",
            "Greysteel",
            "Groggan",
            "Groomsport",
            "Gulladuff",
            "Halfpenny Gate",
            "Hamiltonsbawn",
            "Helens Bay",
            "Hillhall",
            "Hillsborough",
            "Hilltown",
            "Holywell",
            "Holywood",
            "Inishrush",
            "Irvinestown",
            "Jonesborough",
            "Katesbridge",
            "Keady",
            "Kells-Connor",
            "Kellswater",
            "Kesh",
            "Keshbridge",
            "Kilcoo",
            "Kildress",
            "Kilkeel",
            "Killadeas",
            "Killaloo",
            "Killay",
            "Killead",
            "Killeen",
            "Killen",
            "Killeter",
            "Killinchy",
            "Killough",
            "Killowen",
            "Killylea",
            "Killyleagh",
            "Killyman",
            "Killywool",
            "Kilmore",
            "Kilrea",
            "Kilskeery",
            "Kinallen",
            "Kinawley",
            "Kircubbin",
            "Knockcloghrim",
            "Knockmoyle",
            "Knocknacarry",
            "Lack",
            "Landahaussy",
            "Largy",
            "Larne",
            "Lawrencetown",
            "Letterbreen",
            "Lettershendoney",
            "Limavady",
            "Lisbellaw",
            "Lisburn",
            "Lislea",
            "Lisnadill",
            "Lisnarick",
            "Lisnaskea",
            "Loughbrickland",
            "Loughgall",
            "Loughgilly",
            "Loughguile",
            "Loughinisland",
            "Loughmacrory",
            "Loup",
            "Lower Ballinderry",
            "Lurgan",
            "Lurganare",
            "Lurganure",
            "Lurganville",
            "Macken",
            "Macosquin",
            "Madden",
            "Maghaberry",
            "Maghera",
            "Magheraconluce",
            "Magherafelt",
            "Magheralin",
            "Magheramason",
            "Magheramorne",
            "Magheraveely",
            "Maghery",
            "Maguiresbridge",
            "Markethill",
            "Martinstown",
            "Maydown",
            "Mayobridge",
            "Mazetown",
            "Meigh",
            "Middletown",
            "Milford",
            "Millbank",
            "Mill Bay",
            "Millisle",
            "Milltown",
            "Moira",
            "Monea",
            "Moneyglass",
            "Moneymore",
            "Moneyneany",
            "Moneyreagh",
            "Moneyslane",
            "Monteith",
            "Moortown",
            "Moss-Side",
            "Mountfield",
            "Mountjoy",
            "Mounthill",
            "Mountnorris",
            "Moy",
            "Moygashel",
            "Mullaghbawn",
            "Mullaghboy",
            "Mullaghbrack",
            "Mullaghglass",
            "Mullavilly-Laurelvale",
            "Newbuildings",
            "Newcastle",
            "Newry",
            "Newtown Crommelin",
            "Newtownabbey",
            "Newtownards",
            "Newtownbutler",
            "Newtowncloghoge",
            "Newtownhamilton",
            "Newtownstewart",
            "Nixons Corner",
            "Newmills",
            "Omagh",
            "Park",
            "Parkgate",
            "Plumbridge",
            "Pomeroy",
            "Portadown",
            "Portaferry",
            "Portavogie",
            "Portballintrae",
            "Portbraddon",
            "Portglenone",
            "Portrush",
            "Portstewart",
            "Poyntzpass",
            "Randalstown",
            "Rasharkin",
            "Rathfriland",
            "Ravernet",
            "Richhill",
            "Ringsend",
            "Rock",
            "Rosslea",
            "Rostrevor",
            "Roughfort",
            "Rousky",
            "Saintfield",
            "Sandholes",
            "Scarva",
            "Scotch Street",
            "Seaforde",
            "Seskinore",
            "Shanmaghery",
            "Shanvey",
            "Sheeptown",
            "Shrigley",
            "Silverbridge",
            "Sion Mills",
            "Sixmilecross",
            "Skea",
            "Spa",
            "Spamount",
            "Springfield",
            "Stewartstown",
            "Stoneyford",
            "Strabane",
            "Straid",
            "Straidarran",
            "Strangford",
            "Stranocum",
            "Strathfoyle",
            "Straw",
            "Swatragh",
            "Tamnamore",
            "Tandragee",
            "Tartaraghan",
            "Teemore",
            "Templepatrick",
            "Tempo",
            "The Birches",
            "Tobermore",
            "Toome",
            "Trillick",
            "Trory",
            "Tullyhogue",
            "Tullyhommon",
            "Tullylish",
            "Tullynacross",
            "Tullywiggan",
            "Tynan",
            "Upper Ballinderry",
            "Upperlands",
            "Victoria Bridge",
            "Waringsford",
            "Waringstown",
            "Warrenpoint",
            "Washing Bay",
            "Waterfoot",
            "Whitecross",
            "Whitehead",
            "Whiterock",
            "Aberdeen",
            "Airdrie",
            "Alloa",
            "Arbroath",
            "Ayr",
            "Barrhead",
            "Bathgate",
            "Bearsden",
            "Bellshill",
            "Bishopbriggs",
            "Blantyre",
            "Buckhaven",
            "Cambuslang",
            "Clarkston",
            "Clydebank",
            "Coatbridge",
            "Cumbernauld",
            "Dumbarton",
            "Dumfries",
            "Dundee",
            "Dunfermline",
            "East Kilbride",
            "Edinburgh",
            "Elgin",
            "Erskine",
            "Falkirk",
            "Giffnock",
            "Glenrothes",
            "Grangemouth",
            "Greenock",
            "Hamilton",
            "Inverness",
            "Irvine",
            "Johnstone",
            "Kilmarnock",
            "Kilwinning",
            "Kirkcaldy",
            "Kirkintilloch",
            "Larkhall",
            "Livingston",
            "Motherwell",
            "Musselburgh",
            "Newton Mearns",
            "Paisley",
            "Penicuik",
            "Perth",
            "Peterhead",
            "Polmont",
            "Renfrew",
            "Rutherglen",
            "St Andrews",
            "Stenhousemuir",
            "Stirling",
            "Viewpark",
            "Wishaw",
            "Cardiff",
            "Aberaeron",
            "Abercanaid",
            "Abercarn",
            "Newbridge",
            "Aberdare",
            "Abergavenny",
            "Abergele",
            "Aberkenfig",
            "Bryncoch",
            "Aberporth",
            "Abertillery",
            "Abertridwr",
            "Senghenydd",
            "Aberystwyth",
            "Amlwch",
            "Ammanford",
            "Bagillt",
            "Bala",
            "Bangor",
            "Bargoed",
            "Barmouth",
            "Barry",
            "Beaumaris",
            "Beddau",
            "Bedwas",
            "Benllech",
            "Bethesda",
            "Betws",
            "Bishopston",
            "Blackwood",
            "Blaenau Ffestiniog",
            "Blaenavon",
            "Bodelwyddan",
            "Bow Street",
            "Brecon",
            "Bridgend",
            "Brymbo",
            "Gwersyllt",
            "Brynaman",
            "Gwaun-Cae-Gurwen",
            "Brynmawr",
            "Buckley",
            "Builth Wells",
            "Burry Port",
            "Caerleon",
            "Caernarfon",
            "Caerphilly",
            "Caldicot",
            "Cardigan",
            "Carmarthen",
            "Cefn-mawr",
            "Chepstow",
            "Chirk",
            "Church Village",
            "Coedpoeth",
            "Colwyn Bay",
            "Connahs Quay",
            "Conwy",
            "Cowbridge",
            "Creigiau",
            "Criccieth",
            "Croeserw",
            "Cross Hands",
            "Crynant",
            "Cwm",
            "Cwmafan",
            "Pontrhydyfen",
            "Cwmbach",
            "Cwmbran",
            "Cwmllynfell",
            "Cyfarthfa",
            "Denbigh",
            "Dinas Powys",
            "Dolgellau",
            "Dyserth",
            "Ebbw Vale",
            "Ferndale",
            "Fishguard",
            "Flint",
            "Gelligaer",
            "Gilfach Goch",
            "Gilwern",
            "Glan Conwy",
            "Glanaman",
            "Glandwr",
            "Glyn-Neath",
            "Glyncoch",
            "Goodwick",
            "Gorseinon",
            "Greenfield",
            "Gresford",
            "Haverfordwest",
            "Heolgerrig",
            "Holyhead",
            "Holywell",
            "Hope",
            "Caergwrle",
            "Johnston",
            "Kidwelly",
            "Knighton",
            "Lampeter",
            "Langstone",
            "Leeswood",
            "Llanberis",
            "Llanbradach",
            "Llandeilo",
            "Llandovery",
            "Llandrindod Wells",
            "Llandudno",
            "Llandudno Junction",
            "Deganwy",
            "Llandybie",
            "Llanelli",
            "Llanfairfechan",
            "Llanfairpwll",
            "Llangefni",
            "Llangollen",
            "Llangynwyd",
            "Pont-rhyd-y-cyff",
            "Llanharan",
            "Llanharry",
            "Llanhilleth",
            "Llanidloes",
            "Llanrug",
            "Llanrwst",
            "Llantrisant",
            "Pontyclun",
            "Llantwit Fardre",
            "Llantwit Major",
            "Llay",
            "Machen",
            "Machynlleth",
            "Maesteg",
            "Magor",
            "Marshfield",
            "Menai Bridge",
            "Merthyr Tydfil",
            "Merthyr Vale",
            "Milford Haven",
            "Mold",
            "Monmouth",
            "Mostyn",
            "Mountain Ash",
            "Abercynon",
            "Narberth",
            "Neath",
            "New Tredegar",
            "Newcastle Emlyn",
            "Newport",
            "Newtown",
            "Neyland",
            "Northop Hall",
            "Oakdale",
            "Pontllanfraith",
            "Ogmore Vale",
            "Pantymwyn",
            "Gwernaffield",
            "Pembroke",
            "Pembroke Dock",
            "Penarth",
            "Penclawdd",
            "Pencoed",
            "Penmaenmawr",
            "Penrhyn Bay",
            "Penrhyndeudraeth",
            "Penrhys",
            "Pentyrch",
            "Penyffordd",
            "Penygroes",
            "Pontardawe",
            "Clydach",
            "Pontarddulais",
            "Pontlliw",
            "Pontyberem",
            "Pontycymer",
            "Pontypool",
            "Pontypridd",
            "Port Talbot",
            "Porthcawl",
            "Porthmadog",
            "Prestatyn",
            "Presteigne",
            "Price Town",
            "Pwllheli",
            "Pyle",
            "Radyr",
            "Resolven",
            "Rhayader",
            "Rhondda",
            "Rhoose",
            "Rhosllanerchrugog",
            "Rhostyllen",
            "Rhuddlan",
            "Rhyl",
            "Rhymney",
            "Risca",
            "Rogiet",
            "Rosset",
            "Ruabon",
            "Ruthin",
            "Saundersfoot",
            "Seven Sisters",
            "Shotton",
            "Hawarden",
            "Soughton",
            "Southgate",
            "St Asaph",
            "St Clears",
            "St Davids",
            "Swansea",
            "Taffs Well",
            "Tenby",
            "Tongwynlais",
            "Tonyrefail",
            "Tredegar",
            "Treharris",
            "Nelson",
            "Trimsaran",
            "Tumble",
            "Tywyn",
            "Underwood",
            "Usk",
            "Valley",
            "Welshpool",
            "Whelston",
            "Wrexham",
            "Y Felinheli",
            "Ynysybwl",
            "Ystradgynlais",
            "Ystalyfera","Zurich","Geneva","Lucerne","Grenchen","Bettlach","Lengnau",
            "Pieterlen","Huttwil","Langenthal","Lotzwil","Murgenthal","Roggwil","Butzberg",
            "Bannwil","Wynau","Leukerbad","Zermatt","Visp","Brig","Glis","Naters","Saas-Fee",
            "Matzendorf","Oensingen","Egerkingen","Holderbank","Wolfwil","Attiswil","Oberbipp",
            "Balsthal","Mumliswil","Wiedlisbach","Welschenrohr","Mohlin","Niederbipp","Bern",
            "Gumligen","Muri bei Bern","Kirchberg","Hindelbank","Wasen","Burgdorf","Lyssach",
            "Oberburg","Ersigen","Kernenried","Kirchberg","Belp","Munsingen","Rubigen","Toffen",
            "Aarberg","Seedorf","Herzogenbuchsee","Oberonz","Rheinfelden","Therwil","Basel",
            "Oberwil","Binningen","Bottmingen","Pratteln","Oberdorf","Oberdorf","Zeglingen",
            "Wegenstetten","Gelterkinden","Reinach","Seltisberg","Kaiseraugst","Wallisellen",
            "Dubendorf","Collombey","Bouveret","Martigny-Ville","Basse-Nendaz","Saxon",
            "Monthey","Riddes","Arlesheim","Onex","Doettingen","Bariswil","Lausanne",
            "Breitenbach","Thayngen","Uhwiesen","Reinach","Biel/Bienne","Pully","Sachseln",
            "Zizers","Cazis","Chur","Steinhausen","Ebnat-Kappel","Meyrin","Hunenberg",
            "Giubiasco","Laufen","Frauenfeld","Affoltern am Albis","Pfaeffikon","Kriens",
            "Yverdon-les-Bains","Rueti","Wetzikon","Mendrisio","Stabio","Vevey","Orbe",
            "Baar","Uster","Trimbach","Appenzell","Fallanden","Fribourg","Diessenhofen",
            "Sulgen","Kreuzlingen","Schonholzerswilen","Schaffhausen","Bulach","Winterthur",
            "Au","Massagno","Lugano","Rotkreuz","Bernex","St. Gallen","Nidau","Carouge","Wil",
            "Neuenhof","Viganello","Renens","Eysins","Nyon","Prilly","Aigle","Sarnen",
            "Chene-Bourg","Bern / Liebefeld","Erlenbach","Hochdorf","Entlebuch","Unterageri",
            "Dielsdorf","Sissach","Wettingen","Deitingen","Hergiswil","Rupperswil","Forel",
            "Muri","Turbenthal","Laupen","Chiasso","Riva San Vitale","Cadro","Banco","Melide",
            "Chene-Bougeries","Solothurn","Augst","Oberschlatt","Beinwil","Rorschach",
            "Baretswil","Lenzburg","Oberlunkhofen","Villigen","Zaziwil","Hagneck","Schanis",
            "Autigny","DÃ¼dingen","Menziken","Frutigen","Bassersdorf","Nurensdorf",
            "Ruschlikon","Mannedorf","Tenero","Blonay","Weinfelden","Wabern","Wurenlos",
            "Oberentfelden","Jona","Kronbuhl","Goldach","Daettlikon","Schlieren","Montreux",
            "Dornach","Peseux","Allschwil","Marin","Rumlang","Horw","Saint-Sulpice",
            "Munchenstein","Emmenbruecke","Veyrier","Liestal","Klingnau","Dottikon",
            "Windisch","Dietikon","Gland","Celigny","Gingins","Coppet","Crassier",
            "Kriegstetten","Derendingen","Subingen","Lohn","Munchenbuchsee","Urtenen",
            "Schonbuhl","Richenthal","Nussbaumen","Wollerau","Lachen","Merenschwand",
            "Bonstetten","Kuesnacht","Thun","Courtion","Berikon","Nunningen","Kloten"
            ,"Fischingen","Baden","Bioggio","Siebnen","Gummenen","Bex","Rorbas","Embrach",
            "Wittenbach","Teufen AR","Morschwil","Oftringen","Cointrin","Regensdorf",
            "La Chaux-de-Fonds","Neuchatel","Horgen","Richterswil","Oberweningen","Lucens",
            "Moudon","Thierachern","Heimberg","Zollikofen","Wadenswil","Pregassona","Wikon", "Strengelbach","Hagendorf",
            "Olten","Aarau","Volketswil","Crissier","Corgemont","Bellevue","Vernier","Versoix",
            "Plan-les-Ouates","Samstagern","Pfaeffikon","Vullierens","Ecublens","Niederrohrdorf",
            "Fehraltorf","Ausser-Dinhard","Bussigny","Romanel","Saint-Prex","Tegerfelden",
            "Untersiggenthal","Nussbaumen","Birr","Wurenlingen","Endingen","Turgi","Habsburg",
            "Kirchdorf","Holderbank","Gebenstorf","Birmenstorf","Brugg","Seewis im Pratigau",
            "Tamins","Seengen","Wohlen","Egliswil","Nanikon","Meisterschwanden","Bruttisellen",
            "Flums","Untervaz","Domat","Haldenstein","Wangs","Greifensee","Bassecourt",
            "Malleray","Bevilard","Rapperswil","Eschenbach","Roche","Chatel-Saint-Denis",
            "Buchs / Buchs (Dorf)","Bellinzona","Belmont-sur-Lausanne","Zollikon","Le Locle",
            "Altdorf","Courtepin","Lamboing","La Neuveville","Wileroltigen","Speicher",
            "Vacallo","Mettmenstetten","Nottwil","Sursee","Mauensee","Avenches","Couvet",
            "Zofingen","Heerbrugg","Berneck","Ermatingen","Tagerwilen","Holstein","Magden",
            "Colombier","Cornaux","Preles","DelÃ©mont","Minusio","Langnau am Albis","Herisau",
            "Frick","Ober Urdorf","Murten","Vesenaz","Rickenbach","Zug","Feuerthalen",
            "Huntwangen","Wagenhausen","Biberist","Morges","Chardonne","Le Mont-sur-Lausanne",
            "Gossau","Grueningen","KÃ¼ttigen","Troistorrents","Villars-sur-Glane","Gstaad",
            "Sempach","Unterengstringen","Cadempino","Locarno","Tann","Berlikon","Hinwil",
            "Weiningen","Meilen","Oberengstringen","Stettlen","Illnau","KÃ¼ssnacht",
            "Elsau-Raeterschen","Hinterkappelen","Losone","Oetwil / Oetwil an der Limmat",
            "Cham","Vandoeuvres","Morigen","Bristen","Willisau","Beromuenster","Moutier",
            "Hunibach","Schmitten","Ueberstorf","Albligen","Schwarzenburg","KÃ¶niz","Puidoux",
            "Cully","Chexbres","Payerne","Rolle","Gottlieben","Romanshorn","Steckborn",
            "Confignon","Niederuzwil","Oberuzwil","Otelfingen","Andwil","Hettlingen","Elgg",
            "Glattfelden","Thalwil","Rudolfstetten","Oberbuchsiten","Lostorf","Ecuvillens",
            "Avry","Neyruz","GruyÃ¨res","Grandvillard","Treyvaux","Domdidier","Faoug",
            "Broc","Dompierre","Ependes","Opfikon","Henggart","Zell","Russikon",
            "Seuzach Dorf","Hagenbuch","Pfungen","Aadorf","Weisslingen","Gravesano",
            "Morbio Inferiore","Morcote","Littau","Schachen","Dattwil","Courrendlin",
            "Courroux","Coeuve","Chambesy","Bach","Granges","Apples","Cudrefin",
            "Kempttal","Oberembrach","Reconvilier","Saint-Imier","Cortaillod","Boudry",
            "Bevaix","Fontainemelon","Grandson","Estavayer-le-Lac","Champagne","Bolligen",
            "Worblaufen","Jegenstorf","Ostermundigen","Adliswil","Kilchberg","Steffisburg",
            "Spiez","Einigen","Durnten","Hergiswil","Kastanienbaum","Alpnach","Seegraben",
            "Monchaltorf","Ebikon","Aeugst am Albis","Mettmenstetten","Stallikon",
            "Rondchatel","Schenkon","Eich","Oberkirch","Weggis","Emmen","Wiesendangen",
            "Roschenz","Birmensdorf","Herrliberg","Hombrechtikon","Feldmeilen","Stafa",
            "Oetwil am See","Uerikon","Uetikon","Glattburg","Villars-sur-Ollon",
            "Altstatten","Arbon","Buix","Courtemaiche","Courgenay","Courtedoux",
            "Riedholz","Zuchwil","Gerlafingen","Batterkinden","Obergerlafingen"
            ,"Yvonand","Saint-Maurice","Val d'Illiez","Vionnaz","Villeneuve","Ayent","Erde",
            "Sion","Bramois","Sierre","Vetroz","Grimisuat","Saint-Leonard","Ayer","Ossingen",
            "Le Landeron","Altenrhein","Abtwil","Evilard","Tramelan","Orvin","Villeret",
            "Neftenbach","Niederweningen","Koblenz","Leibstadt","Bad Zurzach","Rekingen"
            ,"Porrentruy","Court","Wangen","Buchs","Bremgarten","Eggenwil","Lutry",
            "Ormalingen","Mellingen","Hagglingen","Hendschiken","Trimmis","Arosa",
            "Cheseaux-sur-Lausanne","Uzwil","Unterehrendingen","Saignelegier","Frenkendorf",
            "Unterlunkhofen","Jonen","Les Breuleux","Hermetschwil-Staffeln","Oberwil",
            "Moriken","Reigoldswil","Waldenburg","Oberglatt","Thonex","Eschlikon","Stein",
            "Kaisten","Laufenburg","Hofstetten","Travers","Wahlen","Cottens","Lausen",
            "Brutten","Rothrist","Ã‰challens","Wald","Sainte-Croix","Bubikon","Gossau",
            "Neunkirch","Flaach","Uitikon","Niederurnen","Uetendorf","Brenzikofen",
            "Killwangen","Kehrsatz","Sementina","Bottens","Gunten","Habkern","Rafz",
            "Aarburg","Muhlau","Davos","Schoetz","KÃ¼nten","Schnottwil","Saviese",
            "Conthey","Arbaz","Nax","Evionnaz","Grone","Montana","Martigny-Croix",
            "Chalais","Granges-pres-Sion","Champsec","Champex","Sembrancher","Verbier",
            "Chippis","Vercorin","Fully","Charrat-les-Chenes","DÃ¼rrenroth","Russin"
            ,"Prangins","Fulenbach","Burglen","Rechthalten","Charmey","Niederhallwil",
            "Le Grand-Saconnex","Balerna","Hitzkirch","Winkel","Spreitenbach","Termen",
            "Munster","Oberhelfenschwil","Stansstad","Obfelden","Muhen","Hirzel-Kirche",
            "Rheineck","Wolhusen","Neuheim","Root","Meierskappel","Werthenstein","Neuenkirch",
            "Brunnen","Ottenbach","Walchwil","Kappel","Vuadens","Romont","Bulle","Riaz",
            "Marsens","Siviriez","Chavannes-les-Forts","Hauteville","Maur","Zumikon","Egg",
            "Lignieres","Saint-Blaise","Hauterive","EnnetbÃ¼rgen","Giswil","Thierrens",
            "Epalinges","Wangi","Bazenheid","Cremines","Muhleberg","Bavois","Aubonne",
            "Gimel","Grandval","Pery","Les Genevez","Lurtigen","Lyss","Saint-Livres"
            ,"Meinisberg","Lenzerheide","Langnau","Gwatt","Rikon / Rikon (Dorfkern)",
            "Beringen","Flurlingen","Buch","Schlatt","Trasadingen","Kappel",
            "Portalban- Dessous","Schwyz","Kerns","Enney","Cugy","Kefikon","Le Vaud",
            "Savigny","Daniken","Meggen","Bangerten","Le Cret","Hauptwil","Himmelried","Bissegg","Preverenges","Paudex","Worben","Busswil","Bosingen","Liebistorf","Tafers","Cordast","Heitenried","Ferenbalm","Schubelbach","Ascona","Berg","Rickenbach","Heimiswil","Agno","Erlach","Freienbach","Safenwil","Kerzers","Ins","Siselen","Altendorf","Reichenburg","Ziegelbrucke","Bilten","Kallnach","Unteriberg","La Tour-de-Peilz","Bettingen","Villmergen","Corcelles","Arisdorf","Fullinsdorf","Nafels","Mollis","Hundwil","Uznach","Sankt Gallenkappel","Ennenda","Fahrwangen","Blumenstein","Einsiedeln","Rothenthurm","Corcelles","Sariswil","Thorishaus","Niederlenz","Wildegg","Staufen","Stadel","Airolo","Netstal","Glarus","Goslikon","Sarmenstorf","La Chiesaz","Yvorne","Vouvry","Burglen","Schindellegi","Kolliken","Lungern","Inwil","Felsberg","Kaiserstuhl","Alt-Bachs","Siglistorf","Chavannes","Bottenwil","Brittnau","Vordemwald","Villars",
            "Cossonay","Densbueren","Courtelary","Niedergosgen","Erschwil","Quartino","Saint-Cergue","Chavannes de Bogis","Tesserete","Interlaken","Benken","Suhr","Sonvico","Udligenswil","Pfeffikon","Sigriswil","DÃ¤rligen","Buchs","Muttenz","Caslano","Stein","Othmarsingen","Zuzgen","Canobbio","Stans","Buochs","Dallenwil","Wolfenschiessen","Beckenried","Buren nid dem Bach","BrÃ¼gg","Zuzwil","Neukirch","Amriswil","Horn","Novazzano","Magadino","Gordola","Matzingen","Ellikon an der Thur","Melano","Zwingen","Gunzgen","Ricken","Adligenswil","Steinen","Grosswangen","Rueggisberg","Aeschau","Schinznach Dorf","Obergosgen","Untererlinsbach","Seon","Villnachern","Founex","Jussy","Oron-la-ville","Arth","Aesch","Worb","Cressier","Gryon","Ruswil","Weesen","Wangen","Flamatt","Amsoldingen","Effretikon","Waldstatt","Bonnefontaine","Le Bry","Bellerive","Vex","Veytaux","Epautheyres","Rothenbach","Schoftland","Nesslau","Rebstein","Schattdorf",
            "Grancy","Zuckenriet","Hoerstetten","Essertines-sur-Rolle","L'Abbaye","Biere","Vernayaz","Feldbach","Chapelle","Villaz-Saint-Pierre","Birsfelden","Oberhofen bei Etzgen","Vaulruz","Steg","Vallorbe","Alterswil","Niederbuchsiten","Munchwilen","L'Isle","Plaffeien","Sins","Buttes","Mumpf","Soyhieres","Gampelen","Kiesen","Davos Platz","Vauderens","Chamoson","Ovronnaz","Froideville","Felben","Neu-Rheinau","Lenk","Territet","Leutwil","Oberrieden","Oberstocken","Bubendorf","Veltheim","Grandcour","Tuggen","Saint-Aubin-Sauges","Les Verrieres","Wattwil","Rhazuns","Contone","Brissago","Neuhausen","Tauffelen","Sankt Margrethen","Chatelaine","Vicques","Eschenbach","Cernier","Hildisrieden","Degersheim","Dardagny","Morschach","Malters","Buchrain","Fluehli","Buttisholz","Hellbuehl","Schuepfheim","Cartigny","Rue","Begnins","Coppet","La Plaine","Graenichen","Maggia","Rossens","Busserach","Grindelwald","Basadingen","Dachsen","Eglisau","Rudlingen","Buchberg"
            ,"Stein am Rhein","Nohl","Hemmental","Ramsen","Grabs","Mels","Lienz","Au","Sargans","Balgach","Sevelen","Sennwald","Cressier","Thielle","Gachlingen","Erlen","Diepoldsau","Bad Ragaz","Daillens","Rohrbach","Muolen","Gipf-Oberfrick","Islikon","Wauwil","Freidorf","Schonenwerd","Niedererlinsbach","Wittnau","Thalheim","Auenstein","Schafisheim","Moosleerau","Teufenthal","Unterkulm","Gontenschwil","Reiden","Dagmersellen","Ibach","Fischenthal","Tavannes","Hornussen","Vinzel","Klosters Serneus","Furstenaubruck","Wolfgang","Cheyres","Rohr","Hofstetten","Bachenbulach","Thundorf","Pfaffnau","Corsier","Le Noirmont","Montagnola","Gandria","Selzach","Biel-Benken","Landquart","Arni","Auvernier","Schonenberg","Bauma","Gordevio","Iragna","Durrenasch","Oberegg","Hittnau","Boll","Campfer","Obersaxen","Dombresson","Sottens","Oberdiessbach","Langnau","Geuensee","Utzenstorf","Sezegnin","Koppigen","Bonaduz","Chateau-d'Oex",
            "Corminboeuf","Les Pommerats","Ligerz","Trubschachen","Oberhofen","Miecourt","Courtetelle","La Chaux","Gampel","Ilanz","Bellmund","Emmetten","Grund","Flims","Waldhaus","Laax","Igis","Luvis","Weiningen","Brislach","Buren an der Aare","Belfaux","Attalens","Palezieux","La Sarraz","Wil","Bronschhofen","Hausen","La Roche","Ballwil","Goldau","Sorengo","Agra","Concise","Eiken","Beuson","Scuol","Diegten","Wangen an der Aare","Schonenbuch","Orsonnens","Bigenthal","Baulmes","Ettingen","Aettenschwil","Wigoltingen","Hilterfingen","Kaltbrunn","Chez-le-Bart","Unter-Teufen","Wichtrach","Adelboden","Wimmis","Saanenmoser","Gommiswald","Klosters Platz","Davos Dorf","Eggersriet","BÃ¼hler","Oberriet","Ruthi","Eichberg","Camorino","Pampigny","Yens","Auw","Onnens","Kleinlutzel","Seftigen","Grolley","Weissbad","Kradolf","Mettendorf","Stettfurt","Matt","Assens","Bursins","Morgins","Flawil","Full","Sirnach","Saint-Aubin","Muotathal",
            "Satigny","Vilters","Guttingen","Altishofen","Schongau","Vitznau","Sattel","Attinghausen","Novaggio","Buonas","Bogis-Bossey","Alchenstorf","Noreaz","Buus","Anieres","Alberswil","Immensee","Givrins","Borex","Meinier","Henau","Hausen am Albis / Hausen (Dorf)","Claro","Lodrino","Waldkirch","Richigen","Arogno","Glaris","Maschwanden","Schmerikon","Euthal","Orpund","Zollbruck","Sulz","Hochwald","Gersau","Bottighofen","Walzenhausen","Egnach","Heiden","Maerstetten-Dorf","Mullheim","Grono","Sarn","Tasch","Les Hauts-Geneveys","Tanay","Niederburen","Lutisburg","Mosnang","Maisprach","Amden","Arzier","Gelfingen","Aristau","Schleitheim","Semsales","Porsel","Gerzensee","Niederscherli","Ingenbohl","Courfaivre","Aesch","Gais","Lichtensteig","Pfeffingen","Rueyres","Colombier","Diessbach","Goldiwil","Fraubrunnen","Messen","Konolfingen","Triengen","Castione","Krauchthal","Ursenbach","Chene-Paquier","Sonvilier","Fleurier","Lenz","LÃ¼tzelflÃ¼h",
            "Langenbruck","Uerkheim","Cadenazzo","Cassina d'Agno","Trubbach","Thalheim",
            "Schmitten","Schwellbrunn","Gettnau","Maroggia","Altnau","Roggwil","Oberwangen","Trogen","Chavornay","Vuiteboeuf",
            "Rances","Romainmotier","Le Brassus","Ardon","Leysin","Jonschwil","Engelberg","Biasca","Capolago","Manno","Feldbrunnen","Unterseen","Twann","Arzo","Burchen","Merishausen","UrnÃ¤sch","Balterswil","Menzingen",
            "Iserables","Bissone","Glion","Melchnau","Mettlen","Buetschwil","Zihlschlacht","Ried","Bitsch","Les Geneveys-sur-Coffrane","Pfyn","Riggisberg","Bigorio","Zeihen","Roveredo","Arbedo","Chesieres","Schiers","Seedorf","Erstfeld","Hasle","Felsenau","Kollbrunn","Eggiwil","Rehetobel","Genestrerio","Grellingen","Oberbalm","Gerlikon","Barbereche","Schinznach Bad","Cugnasco","Wila","Iseo","Schwarzenberg","Pura","Waltenschwil","Rapperswil","Gnosca","Perroy","Chancy","Liddes","Grimentz","Seelisberg",
            "Schonried","Greppen","Thusis","Saanen","Zullwil","Sils-Segl Maria","Celerina","Raperswilen","Feusisberg","Sonceboz","Salmsach","Ittenthal","Laufelfingen","Lauerz","Les Acacias","Le Sentier","Herdern","Gonten","Andermatt","Stoos","Zunzgen","Niederhelfenschwil","Wuppenau","Lommis","Ganterschwil","Wilderswil","Ringgenberg","Brienz","Bonigen","Meiringen","Walkringen","Ufhusen","Zell","Ouchy","Villa","Apro","Finhaut","Allaman","Saint-Sulpice","Motiers","Winterberg","Lindau","Schupfen","Perlen","Arcegno","Kulm","Tschuggen","Trun","Wolfhalden","Savognin","Ulrichen","Lauenen","Sumiswald","Cheiry","Vessy","Hunzenschwil","Dozwil","Montet","Wengen","Raron","Verscio","Flueli","Rufi","Hermance","Saas-Grund","Jenaz","Loco","Roemerswil","Aeschlen ob Gunten","Escholzmatt","Ferden","Herbetswil","Grossandelfingen","MÃ¼hlehorn","Muerren","Zufikon",
            "Obervaz","Rifferswil","Les Diablerets","Brusino Arsizio","Sessa"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerserviceoptionsenabled);
//        deviceid = FirebaseInstanceId.getInstance().getToken();



        rggender = (RadioGroup) findViewById(R.id.rg_gender);

        rbmale = (RadioButton) findViewById(R.id.rb_male);
        rbfemale = (RadioButton) findViewById(R.id.rb_female);




//textviews

        tvterms = (TextView)findViewById(R.id.tv_termsss);
        cbox = (CheckBox)findViewById(R.id.cb);

//edittext
        etfullname = (EditText) findViewById(R.id.et_enterfullname);
        etdatebirth = (TextView) findViewById(R.id.et_enterdob);
        etaltermobile = (EditText) findViewById(R.id.et_altermobile);
        etpincode = (EditText) findViewById(R.id.et_pincode);
      etmobile= (EditText) findViewById(R.id.et_mobileno);
        etemail = (EditText) findViewById(R.id.et_emaill);
        etadd1= (EditText) findViewById(R.id.et_address1);
        etadd2= (EditText) findViewById(R.id.et_address2);
        etarea= (EditText) findViewById(R.id.et_area);
        etnearestgurudwara= (EditText) findViewById(R.id.et_nearestgurudwara);

        usr= this.getIntent().getStringExtra("user");

        //button
        btnsubmit=(Button)findViewById(R.id.btn_serviceenable_submit);





//autoFill view
        //city
        atcity=(AutoCompleteTextView)findViewById(R.id.auto_city);
        ArrayAdapter<String> arrayAdaptercity = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item, city);
        //Used to specify minimum number of
        //characters the user has to type in order to display the drop down hint.
        atcity.setThreshold(1);
        //Setting adapter
        atcity.setAdapter(arrayAdaptercity);




        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/avenir-next-regular.ttf");
        Typeface typefacebold = Typeface.createFromAsset(getAssets(), "font/avenir-next-bold.ttf");
        Typeface typefacemedium = Typeface.createFromAsset(getAssets(), "font/AvenirNext-Medium.ttf");

        tvterms.setTypeface(typefacebold);

        etfullname.setTypeface(typefacemedium);
        etdatebirth.setTypeface(typefacemedium);
        etaltermobile.setTypeface(typefacemedium);
        etpincode.setTypeface(typefacemedium);
        etarea.setTypeface(typefacemedium);
        etadd1.setTypeface(typefacemedium);
        etadd2.setTypeface(typefacemedium);
        etmobile.setTypeface(typefacemedium);
        etnearestgurudwara.setTypeface(typefacemedium);





        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbox.isChecked()){
                    btnregister();
                }else {
                    Toast.makeText(Registerserviceoptionsenabled.this,"Please Accept Terms And Conditions",Toast.LENGTH_LONG).show();
                }


            }
        });

        rggender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i==R.id.rb_male){


                    gender = "male";
                }else if(i==R.id.rb_female){

                    gender = "female";


                }
            }});

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

public void btnregister(){

    fullname = etfullname.getText().toString();
    dob = etdatebirth.getText().toString();
    altmobile = etaltermobile.getText().toString();
    pincode = etpincode.getText().toString();
    cty=atcity.getText().toString();
    mobile = etmobile.getText().toString();
    emailid = etemail.getText().toString();
    address1 = etadd1.getText().toString();
    address2 = etadd2.getText().toString();
    area = etarea.getText().toString();
    nearestgurudwara = etnearestgurudwara.getText().toString();
    cty=atcity.getText().toString();


    StringRequest stringRequest = new StringRequest(Request.Method.POST, ConfigInfo.registerservice,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("response..........", response);
                    Toast.makeText(getApplicationContext(),response.toString(), Toast.LENGTH_LONG).show();

                   Intent intent = new Intent(Registerserviceoptionsenabled.this, ThankuPage.class);
                    startActivity(intent);
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Registerserviceoptionsenabled.this, "Error Sign Up Process.Please Check your entered Credentials", Toast.LENGTH_LONG).show();
                }
            }) {
        @Override
        protected Map<String, String> getParams() {
           /* SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("UserProfile", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("email", email);
            editor.putString("password", password);
            editor.putString("reference", reference);
            editor.commit();*/

            Map<String, String> params = new HashMap<String, String>();
            params.put("name", fullname);
            params.put("date_of_birth", dob);
            params.put("gender", gender);
            params.put("mobile_no", mobile);
            params.put("alter_mobile_no", altmobile);
            params.put("address1", address1);
            params.put("nearest_gurudwara_sahib", nearestgurudwara);
            params.put("address2", address2);
            params.put("city", cty);
            params.put("area", area);
            params.put("pincode", pincode);
            params.put("device_id", "232423424");
            params.put("gcm_token", "232423424");
            params.put("email_id", emailid);
            params.put("user_login","prernasyadav027@gmail.com" );
            Log.e(",.,.,.,.,.,.,",""+params);
            return params;
        }

    };

    RequestQueue requestQueue = Volley.newRequestQueue(this);
    requestQueue.add(stringRequest);
}


}
