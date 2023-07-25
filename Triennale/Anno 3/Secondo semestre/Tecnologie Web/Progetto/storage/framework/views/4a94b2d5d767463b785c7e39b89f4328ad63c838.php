

<?php $__env->startSection('content'); ?>
    <div class="container">
        <div class="panel">
            <h2>Lista coupo utilizzati</h2>

            <div class="search-container">
                <form id="search-form" method="POST" action="<?php echo e(route('listaCouponUsati')); ?>">
                    <?php echo csrf_field(); ?>
                    <div class="search-wrapper">
                        <!-- l'evento onkeyup viene attivato quando viene premuto un tasto qualsiasi della tastiera quando ho il focus sull'input -->
                        <input type="text" id="search-bar" name="query" onkeyup="search()" placeholder="Cerca un coupon scrivendo il nome dell'offerta associata..." title="Cerca un coupon scrivendo qui e poi premendo il tasto INVIO/ENTER">
                        <button type="submit"><img src="<?php echo e(asset("assets/images/search.svg")); ?>" alt="Cerca"></button>
                    </div>
                </form>
            </div>
            <br>
            <br>
            <table class="tabella">
                <thead>
                <tr>
                    <th>Cliente</th>
                    <th>Offerta</th>
                    <th>Azienda</th>
                    <th>Data creazione</th>
                    <th>Data scadenza</th>
                    <th>Codice</th>
                </tr>
                </thead>

                <tbody>
                <?php $__currentLoopData = $List; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $list): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                    <tr>
                        <td><?php echo e($list['username']); ?></td>
                        <td><?php echo e($list['nomeOfferte']); ?></td>
                        <td><?php echo e($list['nomeAziende']); ?></td>
                        <td><?php echo e($list['dataOraCreazione']); ?></td>
                        <td><?php echo e($list['dataOraScadenza']); ?></td>
                        <td><?php echo e($list['codice']); ?></td>
                    </tr>
                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                </tbody>
            </table>

            <div class="panel-buttons">
                <a class="btn btn-back" href="<?php echo e(route('hubUtente')); ?>">Torna indietro</a>
            </div>
        </div>
    </div>
<?php $__env->stopSection(); ?>


<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/listaCouponUsati.blade.php ENDPATH**/ ?>