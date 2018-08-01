package com.example.android.modeloevento.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.modeloevento.R;
import com.example.android.modeloevento.adapter.AtracoesAdapter;
import com.example.android.modeloevento.adapter.BotaoAdapter;
import com.example.android.modeloevento.fragments.FragmentAniversarios;
import com.example.android.modeloevento.fragments.FragmentAtracoes;
import com.example.android.modeloevento.fragments.FragmentCampanha;
import com.example.android.modeloevento.fragments.FragmentEstrutura;
import com.example.android.modeloevento.fragments.FragmentEvento;
import com.example.android.modeloevento.fragments.FragmentExcursoes;
import com.example.android.modeloevento.fragments.FragmentInstagram;
import com.example.android.modeloevento.fragments.FragmentLoja;
import com.example.android.modeloevento.fragments.FragmentNews;
import com.example.android.modeloevento.fragments.FragmentPontosVenda;
import com.example.android.modeloevento.fragments.FragmentSetores;
import com.example.android.modeloevento.fragments.FragmentTickets;
import com.example.android.modeloevento.fragments.FragmentVideos;
import com.example.android.modeloevento.fragments.FragmentVideosInformacoes;
import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {

    protected DrawerLayout drawerLayout;
    protected String[] strings;
    protected ArrayList<String> stringsList;
    protected BotaoAdapter adapter;
    private NavigationView navigationView;
    public FragmentManager fragmentManager;
    public FragmentTransaction fragmentTransaction;
    private Toolbar toolbar;

    protected void setUpToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    protected void setUpNavDrawer(){
        // Drawer layout
        final ActionBar actionBar = getSupportActionBar();
        // Icone do menu do nav drawer
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_48dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if(navigationView != null && drawerLayout != null){
            // Trata o evento de clique no menu
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    // Seleciona a linha
                    item.setChecked(true);
                    // Fecha o menu
                    drawerLayout.closeDrawers();
                    // Trata o evento do menu
                    onNavDrawerItemSelected(item);
                    return true;
                }
            });
        }
    }

    public void setUpFragmentManager(){
        fragmentManager = getSupportFragmentManager();
    }

    private void clearBackStack(){
        if(fragmentManager == null){
            setUpFragmentManager();
        }
        for(int i = 0; i< fragmentManager.getBackStackEntryCount(); ++i){
            fragmentManager.popBackStack();
        }
    }

    protected void carregarFragSelecionadoInicialmente(int idClicado){

        switch(idClicado){
            case 0:
                FragmentEvento fragEvento = new FragmentEvento();
                replaceFragment(fragEvento);
                navigationView.setCheckedItem(R.id.nav_item_evento);
                break;

            case 1:
                FragmentAtracoes fragAtracoes = new FragmentAtracoes();
                replaceFragment(fragAtracoes);
                navigationView.setCheckedItem(R.id.nav_item_atracoes);
                break;

            case 2:
                FragmentSetores fragSetores = new FragmentSetores();
                replaceFragment(fragSetores);
                navigationView.setCheckedItem(R.id.nav_item_setores);
                break;

            case 3:
                FragmentEstrutura fragmentEstrutura = new FragmentEstrutura();
                replaceFragment(fragmentEstrutura);
                navigationView.setCheckedItem(R.id.nav_item_estrutura);
                break;

            case 4:
                FragmentTickets fragmentTickets = new FragmentTickets();
                replaceFragment(fragmentTickets);
                navigationView.setCheckedItem(R.id.nav_item_tickets);
                break;

            case 5:
                FragmentNews fragmentNews = new FragmentNews();
                replaceFragment(fragmentNews);
                navigationView.setCheckedItem(R.id.nav_item_news);
                break;

            case 6:
                FragmentVideos fragmentVideos = new FragmentVideos();
                replaceFragment(fragmentVideos);
                navigationView.setCheckedItem(R.id.nav_item_videos);
                break;

            case 7:
                FragmentInstagram fragmentInstagram = new FragmentInstagram();
                replaceFragment(fragmentInstagram);
                navigationView.setCheckedItem(R.id.nav_item_instagram);
                break;

            case 8:
                FragmentLoja fragmentLoja = new FragmentLoja();
                replaceFragment(fragmentLoja);
                navigationView.setCheckedItem(R.id.nav_item_loja);
                break;

            case 9:
                FragmentPontosVenda fragmentPontosVenda = new FragmentPontosVenda();
                replaceFragment(fragmentPontosVenda);
                navigationView.setCheckedItem(R.id.nav_item_pontos_de_venda);
                break;

            case 10:
                FragmentExcursoes fragmentExcursoes = new FragmentExcursoes();
                replaceFragment(fragmentExcursoes);
                navigationView.setCheckedItem(R.id.nav_item_excursoes);
                break;

            case 11:
                FragmentAniversarios fragmentAniversarios = new FragmentAniversarios();
                replaceFragment(fragmentAniversarios);
                navigationView.setCheckedItem(R.id.nav_item_aniversarios);
                break;

            case 12:
                FragmentCampanha fragmentCampanha = new FragmentCampanha();
                replaceFragment(fragmentCampanha);
                navigationView.setCheckedItem(R.id.nav_item_campanha);
                break;
        }
    }

    // Preenchendo a lista
    protected void preencherLista(){
        strings = getResources().getStringArray(R.array.string_array_menu);
        stringsList = new ArrayList();
        for(int i = 0; i<strings.length;i++){
            stringsList.add(strings[i]);
        }
    }




    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                // Trata o clique no botão que abre o menu
                if(drawerLayout != null){
                    openDrawer();
                    break;
                }
                break;

            case R.id.action_open_browser:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/aztec.festival/"));
                startActivity(intent);
                break;

            case R.id.action_video_open_browser:
                Intent intentVideo = new Intent(Intent.ACTION_VIEW);
                intentVideo.setData(Uri.parse("https://www.youtube.com/watch?v="+ FragmentVideosInformacoes.VIDEO_ID));
                startActivity(intentVideo);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void openDrawer(){
        if(drawerLayout != null){
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    protected void closeDrawer(){
        if(drawerLayout != null){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void replaceFragment(Fragment f){
        if(fragmentManager == null){
            setUpFragmentManager();
        }
        clearBackStack();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_layout, f, null);
        fragmentTransaction.commit();
    }

    private void onNavDrawerItemSelected(MenuItem menuItem){

        switch(menuItem.getItemId()){
            case R.id.nav_item_evento:
                FragmentEvento fragEvento = new FragmentEvento();
                replaceFragment(fragEvento);
                break;

            case R.id.nav_item_atracoes:
                FragmentAtracoes fragAtracoes = new FragmentAtracoes();
                replaceFragment(fragAtracoes);
                break;

            case R.id.nav_item_setores:
                FragmentSetores fragSetores = new FragmentSetores();
                replaceFragment(fragSetores);
                break;

            case R.id.nav_item_estrutura:
                FragmentEstrutura fragmentEstrutura = new FragmentEstrutura();
                replaceFragment(fragmentEstrutura);
                break;

            case R.id.nav_item_tickets:
                FragmentTickets fragmentTickets = new FragmentTickets();
                replaceFragment(fragmentTickets);
                break;

            case R.id.nav_item_news:
                FragmentNews fragmentNews = new FragmentNews();
                replaceFragment(fragmentNews);
                break;

            case R.id.nav_item_videos:
                FragmentVideos fragmentVideos = new FragmentVideos();
                replaceFragment(fragmentVideos);
                break;

            case R.id.nav_item_instagram:
                FragmentInstagram fragmentInstagram = new FragmentInstagram();
                replaceFragment(fragmentInstagram);
                break;

            case R.id.nav_item_loja:
                FragmentLoja fragmentLoja = new FragmentLoja();
                replaceFragment(fragmentLoja);
                break;

            case R.id.nav_item_pontos_de_venda:
                FragmentPontosVenda fragmentPontosVenda = new FragmentPontosVenda();
                replaceFragment(fragmentPontosVenda);
                break;

            case R.id.nav_item_excursoes:
                FragmentExcursoes fragmentExcursoes = new FragmentExcursoes();
                replaceFragment(fragmentExcursoes);
                break;

            case R.id.nav_item_aniversarios:
                FragmentAniversarios fragmentAniversarios = new FragmentAniversarios();
                replaceFragment(fragmentAniversarios);
                break;

            case R.id.nav_item_campanha:
                FragmentCampanha fragmentCampanha = new FragmentCampanha();
                replaceFragment(fragmentCampanha);
                break;

            case R.id.nav_item_mapa:
                Toast.makeText(this, "Clicou em mapa", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_item_termos_e_condicoes:
                Toast.makeText(this, "Clicou em termos e condições", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
