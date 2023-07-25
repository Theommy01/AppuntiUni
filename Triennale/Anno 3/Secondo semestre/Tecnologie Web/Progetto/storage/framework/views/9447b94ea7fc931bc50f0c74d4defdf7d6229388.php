<?php $__env->startSection('content'); ?>
    <div class="container">
        <div class="panel">
            <div class="title-with-logo">
                <img src="<?php echo e(asset('assets/images/staff_icon.png')); ?>" alt="Logo staff">
                <h2>Benvenuto nell'Area personale, <?php echo e(Auth::user()->nome); ?> <?php echo e(Auth::user()->cognome); ?></h2>
            </div>
            <div class="panel-buttons">
                <a href="<?php echo e(route('modificaDati_L2')); ?>" class="btn">Modifica dati personali</a>
            </div>
            <div class="panel-buttons">
                <a href="<?php echo e(route('gestioneOfferte')); ?>" class="btn">Gestione offerte</a>
            </div>
            
            <div class="panel-buttons">
                <a href="" class="btn btn-back" title="Esci dal sito" onclick="event.preventDefault(); document.getElementById('logout-form').submit();">Logout</a></li>
                <form id="logout-form" action="<?php echo e(route('logout')); ?>" method="POST" style="display: none;">
                    <?php echo e(csrf_field()); ?>

                </form>
            </div>
        </div>
    </div>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/hubStaff.blade.php ENDPATH**/ ?>