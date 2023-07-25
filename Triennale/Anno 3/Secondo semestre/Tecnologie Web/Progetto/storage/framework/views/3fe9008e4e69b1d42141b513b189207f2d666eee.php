

<?php $__env->startSection('title', 'Cancellazione clienti'); ?>

<?php $__env->startSection('content'); ?>
    <div class="container">
        <div class="panel">
            <h2>Cancellazione Clienti</h2>

            <div class="search-container">
                <form id="search-form" method="POST" action="<?php echo e(route('cancellazioneClienti')); ?>">
                    <?php echo csrf_field(); ?>
                    <div class="search-wrapper">
                        <!-- l'evento onkeyup viene attivato quando viene premuto un tasto qualsiasi della tastiera quando ho il focus sull'input -->
                        <input type="text" id="search-bar" name="query" placeholder="Cerca un cliente..." title="Cerca un cliente scrivendo qui e poi premendo il tasto INVIO/ENTER">
                        <button type="submit"><img src="<?php echo e(asset("assets/images/search.svg")); ?>" alt="Cerca"></button>
                    </div>
                </form>
            </div>

            <table class="tabella">
                <thead>
                    <tr>
                        <th>Clienti</th>
                        <th>Elimina</th>
                    </tr>
                </thead>

                <tbody>
                <?php $__currentLoopData = $List; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $list): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                    <tr>
                        <td><?php echo e($list['username']); ?></td>
                        <td title="Clicca qui per ELIMINARE la seguente domanda/risposta">
                           <form class="delete-form" action="<?php echo e(route('eliminaClienti', $list['username'])); ?>" method="POST">
                                <?php echo csrf_field(); ?>
                                <?php echo method_field('DELETE'); ?>
                                <button type="submit" class="btn-table-delete" onclick="return confirm('Sei sicuro di voler eliminare questa domanda?')">
                                    Elimina</button>
                            </form>
                        </td>
                    </tr>
                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                </tbody>
            </table>

            <div class="panel-buttons">
                <a class="btn btn-back" href="<?php echo e(route('hubUtente')); ?>">Torna indietro</a>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="<?php echo e(asset('assets/js/searchOfferta.js')); ?>"></script>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/admin/cancellazioneClienti.blade.php ENDPATH**/ ?>