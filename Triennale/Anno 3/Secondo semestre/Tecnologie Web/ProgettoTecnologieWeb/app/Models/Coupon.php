<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Coupon extends Model
{
    use HasFactory;
    public $table = "coupons";
    public $timestamps = false;
    protected $fillable =
        [
            'usernameCliente',
            'idOfferta',
        ];
}
