package com.example.android.modeloevento.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.modeloevento.R;
import com.example.android.modeloevento.activity.BaseActivity;
import com.example.android.modeloevento.adapter.AtracoesAdapter;
import com.example.android.modeloevento.adapter.LojaAdapter;
import com.example.android.modeloevento.adapter.NewsAdapter;
import com.example.android.modeloevento.adapter.SetoresAdapter;
import com.example.android.modeloevento.adapter.TicketsAdapter;
import com.example.android.modeloevento.adapter.VideosAdapter;

import java.util.ArrayList;

public class BaseFragment extends Fragment {

    private String[] atracoesStrings;
    protected ArrayList<String> atracoes;
    private String[] descricoesStrings;
    protected ArrayList<String> descricoes;
    private RecyclerView rvAtracoes;
    private AtracoesAdapter atracoesAdapter;

    private String[] setoresStrings;
    protected ArrayList<String> setores;
    private String[] setoresDescStrings;
    protected ArrayList<String> setoresDescricoes;
    private SetoresAdapter setoresAdapter;
    private RecyclerView rvSetores;

    private String[] ticketsStrings;
    protected ArrayList<String> tickets;
    private String[] ticketsDescricoesStrings;
    protected ArrayList<String> ticketsDescricoes;
    private TicketsAdapter ticketsAdapter;
    private RecyclerView rvTickets;

    private String[] newsDatasStrings;
    protected ArrayList<String> newsDatas;
    private String[] newsDescStrings;
    protected ArrayList<String> newsDesc;
    private NewsAdapter newsAdapter;
    private RecyclerView rvNews;

    private String[] videosStrings;
    protected ArrayList<String> videos;
    private String[] descricoesVideosStrings;
    protected ArrayList<String> descricoesVideos;
    private VideosAdapter videosAdapter;
    private RecyclerView rvVideos;

    private String[] stringsItensLoja, stringsDescItensLoja, stringsPrecosItensLoja;
    protected ArrayList<String> itensLoja, descItensLoja, precosItensLoja;
    private LojaAdapter lojaAdapter;
    private RecyclerView rvLoja;

    protected void getAtracoes(){
        atracoesStrings = getActivity().getResources().getStringArray(R.array.atracoes);
        atracoes = new ArrayList<String>();
        for(int i = 0; i<atracoesStrings.length;i++){
            atracoes.add(atracoesStrings[i]);
        }

        descricoesStrings = getActivity().getResources().getStringArray(R.array.descricoes);
        descricoes = new ArrayList<String>();
        for(int i = 0; i<descricoesStrings.length; i++){
            descricoes.add(descricoesStrings[i]);
        }
    }

    protected void setAtracoes(){
        rvAtracoes = (RecyclerView) getActivity().findViewById(R.id.rv_atracoes);

        atracoesAdapter = new AtracoesAdapter(getActivity(), atracoes, descricoes, onClickAtracao());
        rvAtracoes.setAdapter(atracoesAdapter);
        rvAtracoes.setHasFixedSize(true);
        rvAtracoes.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    protected AtracoesAdapter.AtracaoOnClickListener onClickAtracao(){
        return new AtracoesAdapter.AtracaoOnClickListener() {
            @Override
            public void onClickArtista(View view, int position) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                AtracoesInformacoesFragment fragInformacoesAtracoes = new AtracoesInformacoesFragment();
                Bundle args = new Bundle();
                args.putInt("atracao", position);
                fragInformacoesAtracoes.setArguments(args);
                ft.replace(R.id.frag_layout, fragInformacoesAtracoes, "FRAG INFORMACOES ATRACOES");
                ft.addToBackStack(null);
                ft.commit();
            }
        };
    }

    protected void getSetores(){
        setoresStrings = getActivity().getResources().getStringArray(R.array.array_setores);
        setores = new ArrayList<String>();
        for (int i = 0; i < setoresStrings.length; i++) {
            setores.add(setoresStrings[i]);
        }


        setoresDescStrings = getActivity().getResources().getStringArray(R.array.array_setores_descricoes);
        setoresDescricoes = new ArrayList<String>();
        for(int i = 0; i<setoresDescStrings.length; i++){
            setoresDescricoes.add(setoresDescStrings[i]);
        }
    }

    protected void setSetores(){
        rvSetores = (RecyclerView) getActivity().findViewById(R.id.rv_setores);
        setoresAdapter = new SetoresAdapter(getActivity(), setores, setoresDescricoes, onClickSetores());
        rvSetores.setAdapter(setoresAdapter);
        rvSetores.setHasFixedSize(true);
        rvSetores.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    protected SetoresAdapter.SetoresOnClickListener onClickSetores(){
        return new SetoresAdapter.SetoresOnClickListener() {
            @Override
            public void onClickSetores(View view, int position) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                SetoresInformacoesFragment setoresInformacoesFragment = new SetoresInformacoesFragment();
                Bundle args = new Bundle();
                args.putInt("setor", position);
                setoresInformacoesFragment.setArguments(args);
                ft.replace(R.id.frag_layout, setoresInformacoesFragment, "FRAG INFORMACOES SETORES");
                ft.addToBackStack(null);
                ft.commit();
            }
        };
    }

    protected void getTickets(){
        ticketsStrings = getActivity().getResources().getStringArray(R.array.array_tickets);
        tickets = new ArrayList<>();
        for(int i = 0; i<ticketsStrings.length; i++){
            tickets.add(ticketsStrings[i]);
        }

        ticketsDescricoesStrings = getActivity().getResources().getStringArray(R.array.array_tickets_desc);
        ticketsDescricoes = new ArrayList<>();
        for(int i = 0; i<ticketsDescricoesStrings.length; i++){
            ticketsDescricoes.add(ticketsDescricoesStrings[i]);
        }
    }

    protected void setTickets(){
        rvTickets = (RecyclerView) getActivity().findViewById(R.id.rv_tickets);
        ticketsAdapter = new TicketsAdapter(getActivity(), tickets, ticketsDescricoes, onClickTickets());
        rvTickets.setAdapter(ticketsAdapter);
        rvTickets.setHasFixedSize(true);
        rvTickets.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    protected TicketsAdapter.TicketsOnClickListener onClickTickets(){
        return new TicketsAdapter.TicketsOnClickListener() {
            @Override
            public void onClickTickets(View view, int position) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentTicketsInformacoes fragmentTicketsInformacoes = new FragmentTicketsInformacoes();
                Bundle args = new Bundle();
                args.putInt("ticket", position);
                fragmentTicketsInformacoes.setArguments(args);
                ft.replace(R.id.frag_layout, fragmentTicketsInformacoes, "FRAG INFORMACOES TICKETS");
                ft.addToBackStack(null);
                ft.commit();
            }
        };
    }

    protected void goToUrl(){
        Uri uriUrl = Uri.parse("https://www.google.com");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    protected void getNews(){
        newsDatasStrings = getActivity().getResources().getStringArray(R.array.array_datas);
        newsDatas = new ArrayList<>();
        for(int i = 0; i<newsDatasStrings.length; i++){
            newsDatas.add(newsDatasStrings[i]);
        }

        newsDescStrings = getActivity().getResources().getStringArray(R.array.array_news_descricoes);
        newsDesc = new ArrayList<>();
        for(int i = 0; i< newsDescStrings.length; i++){
            newsDesc.add(newsDescStrings[i]);
        }
    }

    protected void setNews(){
        rvNews = (RecyclerView) getActivity().findViewById(R.id.rv_news);
        newsAdapter = new NewsAdapter(getActivity(), newsDatas, newsDesc, onClickNews());
        rvNews.setAdapter(newsAdapter);
        rvNews.setHasFixedSize(true);
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    protected NewsAdapter.NewsOnClickListener onClickNews(){
        return new NewsAdapter.NewsOnClickListener() {
            @Override
            public void onClickNews(View view, int position) {
                // DO SOMETHING HERE!
            }
        };
    }

    protected void getVideos(){
        videosStrings = getActivity().getResources().getStringArray(R.array.array_videos);
        descricoesVideosStrings = getActivity().getResources().getStringArray(R.array.array_descricoes_videos);
        videos = new ArrayList<>();
        descricoesVideos = new ArrayList<>();
        for(int i = 0; i < videosStrings.length; i++){
            videos.add(videosStrings[i]);
            descricoesVideos.add(descricoesVideosStrings[i]);
        }
    }

    protected void setVideos(){
        rvVideos = (RecyclerView) getActivity().findViewById(R.id.rv_videos);
        videosAdapter = new VideosAdapter(getActivity(), videos, descricoesVideos, onClickVideos());
        rvVideos.setAdapter(videosAdapter);
        rvVideos.setHasFixedSize(true);
        rvVideos.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    protected VideosAdapter.VideosOnClickListener onClickVideos(){
        return new VideosAdapter.VideosOnClickListener() {
            @Override
            public void onClickVideos(View view, int position) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentVideosInformacoes fragmentVideosInformacoes = new FragmentVideosInformacoes();
                ft.replace(R.id.frag_layout, fragmentVideosInformacoes, "FRAG VIDEOS INFORMACOES");
                ft.addToBackStack(null);
                ft.commit();
            }
        };
    }

    protected void getItensLoja(){
        stringsItensLoja = getActivity().getResources().getStringArray(R.array.array_itens_loja);
        stringsDescItensLoja = getActivity().getResources().getStringArray(R.array.array_loja_desc);
        stringsPrecosItensLoja = getActivity().getResources().getStringArray(R.array.array_loja_precos);
        itensLoja = new ArrayList<>();
        descItensLoja = new ArrayList<>();
        precosItensLoja = new ArrayList<>();
        for(int i = 0; i < stringsItensLoja.length; i++){
            itensLoja.add(stringsItensLoja[i]);
            descItensLoja.add(stringsDescItensLoja[i]);
            precosItensLoja.add(stringsPrecosItensLoja[i]);
        }
    }

    protected void setItensLoja(){
        rvLoja = (RecyclerView) getActivity().findViewById(R.id.rv_loja);
        lojaAdapter = new LojaAdapter(getActivity(), itensLoja, descItensLoja, precosItensLoja, onClickLoja());
        rvLoja.setAdapter(lojaAdapter);
        rvLoja.setHasFixedSize(true);
        rvLoja.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    protected LojaAdapter.LojaOnClickListener onClickLoja(){
        return new LojaAdapter.LojaOnClickListener() {
            @Override
            public void onClickLoja(View view, int position) {
                // DO SOMETHING HERE.
            }
        };
    }

    protected void setPontosDeVenda(){
        TextView tvTituloPontosDeVenda, tvP1PontosDeVenda, tvP2PontosDeVenda;

        tvTituloPontosDeVenda = getActivity().findViewById(R.id.tv_titulo_pontos_de_venda);
        tvP1PontosDeVenda = getActivity().findViewById(R.id.tv_p1_pontos_de_venda);
        tvP2PontosDeVenda = getActivity().findViewById(R.id.tv_p2_pontos_de_venda);

        tvTituloPontosDeVenda.setText(getActivity().getResources().getString(R.string.titulo_pontos_de_venda));
        tvP1PontosDeVenda.setText(getActivity().getResources().getString(R.string.p1_pontos_de_venda));
        tvP2PontosDeVenda.setText(getActivity().getResources().getString(R.string.p2_pontos_de_venda));
    }
}
