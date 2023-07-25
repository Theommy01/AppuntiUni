
<?php $__env->startSection('title', 'Statistiche del sito'); ?>

<?php $__env->startSection('content'); ?>
    <div class="container">
        <div class="panel">
            <h1>Statistiche</h1>

            <div class="two-cols-layout">
                <div class="col">
                    <h2 class="col-title">Per promozione</h2>

                    <div class="callout">
                        <img src="<?php echo e(asset('assets/images/shop.jpg')); ?>" alt="Area contenente il numero di coupon emessi per ogni promozione">
                        <span id="promoCouponsNumber">Clicca su una promozione per conoscere il numero di coupon emessi per questa.</span>
                    </div>

                    <form id="search-promo-form" method="POST" action="<?php echo e(route('statistiche.ricerca')); ?>">
                        <?php echo csrf_field(); ?>
                        <div class="search-wrapper">
                            <!-- l'evento onkeyup viene attivato quando viene premuto un tasto qualsiasi della tastiera quando ho il focus sull'input -->
                            <input type="text" name="promoSearchQuery" placeholder="Ricerca offerta"
                                   title="Cerca un'offerta scrivendo qui e poi premendo il tasto INVIO/ENTER">
                            <button type="submit"><img src="<?php echo e(asset("assets/images/search.svg")); ?>" alt="Cerca"></button>
                        </div>
                    </form>

                    <div class="list">
                        <?php $__currentLoopData = $Promo; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $promo): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                            <a href="#" onclick="getPromoCoupons(<?php echo e($promo['id']); ?>)" class="list-item">
                                [<?php echo e($promo['id']); ?>] <?php echo e($promo['nome']); ?>

                            </a>
                        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                    </div>
                </div>

                <div class="col">
                    <h2 class="col-title">Per cliente</h2>

                    <div class="callout">
                        <img src="<?php echo e(asset('assets/images/customers.png')); ?>" width="30" alt="Area contenente il numero di coupon emessi da ogni cliente">
                        <span id="customerCouponsNumber">Clicca su un cliente per conoscere quanti coupon ha richiesto.</span>
                    </div>

                    <form id="search-cliente-form" method="POST" action="<?php echo e(route('statistiche.ricerca')); ?>">
                        <?php echo csrf_field(); ?>
                        <div class="search-wrapper">
                            <!-- l'evento onkeyup viene attivato quando viene premuto un tasto qualsiasi della tastiera quando ho il focus sull'input -->
                            <input type="text" name="clienteSearchQuery" placeholder="Ricerca username"
                                   title="Cerca un cliente scrivendo qui e poi premendo il tasto INVIO/ENTER">
                            <button type="submit"><img src="<?php echo e(asset("assets/images/search.svg")); ?>" alt="Cerca"></button>
                        </div>
                    </form>

                    <div class="list">
                        <?php $__currentLoopData = $Clienti; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $cliente): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                            <a href="#" onclick="getClientiCoupons('<?php echo e($cliente['username']); ?>')" class="list-item">
                                <?php echo e($cliente['nome']); ?> <?php echo e($cliente['cognome']); ?> (<?php echo e($cliente['username']); ?>)
                            </a>
                        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                    </div>
                </div>
            </div>

            <p class="emphatized-text">
                In totale sono stati emessi <strong id="numCoupon"><?php echo e($NumeroCoupon); ?></strong> coupons.
            </p>

            <div class="panel-buttons">
                <a href="<?php echo e(route('hubAmministratore')); ?>" class="btn btn-back">Torna indietro</a>
            </div>
        </div>
    </div>

    <script src="<?php echo e(asset('assets/js/statsManager.js')); ?>"></script>

    <script>
        // qui ci metto gli URL necessari per le due chiamate AJAX possibili con questa pagina
        // queste variabili verranno poi chiamate dalle funzioni che eseguono le chiamate AJAX.
        var promoCouponsUrl = "<?php echo e(route('statistiche.offerta')); ?>";
        var clienteCouponsUrl = "<?php echo e(route('statistiche.cliente')); ?>";

        // NOTA: il token CSRF viene incluso nelle chiamate AJAX perchè viene richiesto da Laravel, allo scopo di impedire
        // gli attacchi di tipologia Cross-Site Request Forgery (CSRF).
        var csrfToken = "<?php echo e(csrf_token()); ?>";
    </script>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/statistiche.blade.php ENDPATH**/ ?>