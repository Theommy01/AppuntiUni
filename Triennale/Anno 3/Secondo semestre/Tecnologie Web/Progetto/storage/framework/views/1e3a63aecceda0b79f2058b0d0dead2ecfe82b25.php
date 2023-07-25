<nav>
    <!-- area di sinistra: contiene logo di Offertopoli -->
    <div class="navbar-logo-container">
        <img src="<?php echo e(asset('assets/images/logo_with_text.png')); ?>" class="navbar-logo" alt="Logo Offertopoli">
    </div>

    <!-- area di destra: contiene i link che indirizzano alle pagine del sito web -->
    <div class="navbar-links-container">
        <ul>
            <li><a href="<?php echo e(route('homepage')); ?>">Home</a></li>
            <li><a href="<?php echo e(route('aziende')); ?>">Aziende</a></li>
            <li><a href="<?php echo e(route('catalogo')); ?>">Catalogo</a></li>
            <?php if(auth()->guard()->guest()): ?>
                <li><a href="<?php echo e(route('login')); ?>">Login</a></li>
            <?php endif; ?>
            <?php if(auth()->guard()->check()): ?>
                <li><a href="<?php echo e(route('hubUtente')); ?>">Area Personale</a></li>
            <?php endif; ?>
        </ul>
    </div>
</nav>
<?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/layouts/navbar.blade.php ENDPATH**/ ?>