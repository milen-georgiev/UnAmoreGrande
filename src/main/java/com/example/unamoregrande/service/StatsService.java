package com.example.unamoregrande.service;

import com.example.unamoregrande.model.view.StatsView;

public interface StatsService {
    void onRequest();

    StatsView getStats();
}
