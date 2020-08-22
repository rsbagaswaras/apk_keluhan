package com.example.form_keluhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ZoomControls;


public class Lantai1Activity extends AppCompatActivity {

    ZoomControls zoomControls;
    Button btn_lant2, btn_a, btn_b, btn_c, btn_d, btn_dd, btn_e, btn_f, btn_g, btn_h, btn_j, btn_k, btn_l,
            btn_m, btn_n, btn_o, btn_p, btn_q, btn_r, btn_s, btn_ss, btn_t, btn_tt, btn_u, btn_v, btn_w,
            btn_x, btn_y, btn_z, btn_zz;

    Button  btn_aa, btn_ab, btn_ac, btn_ac2, btn_ad, btn_ae, btn_af, btn_ag, btn_ah, btn_ai, btn_aj,
            btn_ak, btn_ak2, btn_al, btn_am, btn_an, btn_ao, btn_ap, btn_aq, btn_ar, btn_ar2, btn_as, btn_aw, btn_ax,
            btn_ax2, btn_ax3, btn_ax4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lantai1);

        zoomControls = findViewById(R.id.simpleZoomControl); // initiate a ZoomControls
        zoomControls.hide();

        btn_lant2= findViewById(R.id.btn_lant2);
        btn_lant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, Lantai2Activity.class);
                startActivity(intent);
            }
        });

        btn_a = findViewById(R.id.btn_a);
        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_b = findViewById(R.id.btn_b);
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_c = findViewById(R.id.btn_c);
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_d = findViewById(R.id.btn_d);
        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_dd = findViewById(R.id.btn_dd);
        btn_dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_e = findViewById(R.id.btn_e);
        btn_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_f = findViewById(R.id.btn_f);
        btn_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_g = findViewById(R.id.btn_g);
        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungGActivity.class);
                startActivity(intent);
            }
        });

        btn_h = findViewById(R.id.btn_h);
        btn_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_j = findViewById(R.id.btn_j);
        btn_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungJActivity.class);
                startActivity(intent);
            }
        });

        btn_k = findViewById(R.id.btn_k);
        btn_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungKActivity.class);
                startActivity(intent);
            }
        });

        btn_l = findViewById(R.id.btn_l);
        btn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungLActivity.class);
                startActivity(intent);
            }
        });

        btn_m = findViewById(R.id.btn_m);
        btn_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungMActivity.class);
                startActivity(intent);
            }
        });

        btn_n = findViewById(R.id.btn_n);
        btn_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungNActivity.class);
                startActivity(intent);
            }
        });

        btn_o = findViewById(R.id.btn_o);
        btn_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungOActivity.class);
                startActivity(intent);
            }
        });

        btn_p = findViewById(R.id.btn_p);
        btn_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungPActivity.class);
                startActivity(intent);
            }
        });

        btn_q = findViewById(R.id.btn_q);
        btn_q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungQActivity.class);
                startActivity(intent);
            }
        });

        btn_r = findViewById(R.id.btn_r);
        btn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungRActivity.class);
                startActivity(intent);
            }
        });

        btn_s = findViewById(R.id.btn_s);
        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungSActivity.class);
                startActivity(intent);
            }
        });

        btn_ss = findViewById(R.id.btn_ss);
        btn_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungSSActivity.class);
                startActivity(intent);
            }
        });

        btn_t = findViewById(R.id.btn_t);
        btn_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungTActivity.class);
                startActivity(intent);
            }
        });

        btn_tt = findViewById(R.id.btn_tt);
        btn_tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungTTActivity.class);
                startActivity(intent);
            }
        });

        btn_u = findViewById(R.id.btn_u);
        btn_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this,GedungUActivity.class);
                startActivity(intent);
            }
        });

        btn_v = findViewById(R.id.btn_v);
        btn_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_w = findViewById(R.id.btn_w);
        btn_w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_x = findViewById(R.id.btn_x);
        btn_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_y = findViewById(R.id.btn_y);
        btn_y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_z = findViewById(R.id.btn_z);
        btn_z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_zz = findViewById(R.id.btn_zz);
        btn_zz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });


        btn_aa = findViewById(R.id.btn_aa);
        btn_aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungAAActivity.class);
                startActivity(intent);
            }
        });

        btn_ab = findViewById(R.id.btn_ab);
        btn_ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungABActivity.class);
                startActivity(intent);
            }
        });

        btn_ac = findViewById(R.id.btn_ac);
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ac2 = findViewById(R.id.btn_ac2);
        btn_ac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        }) ;

        btn_ad = findViewById(R.id.btn_ad);
        btn_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ae = findViewById(R.id.btn_ae);
        btn_ae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_af = findViewById(R.id.btn_af);
        btn_af.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ag = findViewById(R.id.btn_ag);
        btn_ag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ah = findViewById(R.id.btn_ah);
        btn_ah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungAHActivity.class);
                startActivity(intent);
            }
        });

        btn_ai = findViewById(R.id.btn_ai);
        btn_ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungAIActivity.class);
                startActivity(intent);
            }
        });

        btn_aj = findViewById(R.id.btn_aj);
        btn_aj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GedungAJActivity.class);
                startActivity(intent);
            }
        });

        btn_ak = findViewById(R.id.btn_ak);
        btn_ak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ak2 = findViewById(R.id.btn_ak2);
        btn_ak2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_al = findViewById(R.id.btn_al);
        btn_al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_am = findViewById(R.id.btn_am);
        btn_am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_an = findViewById(R.id.btn_an);
        btn_an.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ao = findViewById(R.id.btn_ao);
        btn_ao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ap = findViewById(R.id.btn_ap);
        btn_ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_aq = findViewById(R.id.btn_aq);
        btn_aq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ar = findViewById(R.id.btn_ar);
        btn_ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ar2 = findViewById(R.id.btn_ar2);
        btn_ar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_as = findViewById(R.id.btn_as);
        btn_as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_aw = findViewById(R.id.btn_aw);
        btn_aw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ax = findViewById(R.id.btn_ax);
        btn_ax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ax2 = findViewById(R.id.btn_ax2);
        btn_ax2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ax3 = findViewById(R.id.btn_ax3);
        btn_ax3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });

        btn_ax4 = findViewById(R.id.btn_ax4);
        btn_ax4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, IgdActivity.class);
                startActivity(intent);
            }
        });


    }
}
